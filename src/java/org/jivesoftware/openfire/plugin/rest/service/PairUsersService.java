package org.jivesoftware.openfire.plugin.rest.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.jivesoftware.openfire.SharedGroupException;
import org.jivesoftware.openfire.plugin.rest.controller.UserServiceController;
import org.jivesoftware.openfire.plugin.rest.entity.RosterItemEntity;
import org.jivesoftware.openfire.plugin.rest.entity.ItemToPairEntity;
import org.jivesoftware.openfire.plugin.rest.entity.ItemToUnpairEntity;
import org.jivesoftware.openfire.plugin.rest.exceptions.ExceptionType;
import org.jivesoftware.openfire.plugin.rest.exceptions.ServiceException;
import org.jivesoftware.openfire.user.UserNotFoundException;
import org.xmpp.packet.JID;
import org.jivesoftware.openfire.roster.RosterItem;

@Path("restapi/v1/users/roster/multipairing")
public class PairUsersService {

    private static final String COULD_NOT_CREATE_ROSTER_ITEM = "Could not create roster item";

    private UserServiceController plugin;

    @PostConstruct
    public void init() {
        plugin = UserServiceController.getInstance();
    }

    @POST
    public Response pairUsers(List<ItemToPairEntity> items)
        throws ServiceException {
        for (ItemToPairEntity item: items) {
            try {
                RosterItemEntity user2RosterEntity = new RosterItemEntity(item.getUser2DeviceXmppLogin(), item.getUser2DeviceName(), RosterItem.SubType.BOTH.getValue());
                List<String> user2RosterEntiryGroups = new ArrayList<String>();
                user2RosterEntiryGroups.add(item.getUser2GroupName());
                user2RosterEntity.setGroups(user2RosterEntiryGroups);

                RosterItemEntity user1RosterEntity = new RosterItemEntity(item.getUser1DeviceXmppLogin(), item.getUser1DeviceName(), RosterItem.SubType.BOTH.getValue());
                List<String> user1RosterEntityGroups = new ArrayList<String>();
                user1RosterEntityGroups.add(item.getUser1GroupName());
                user1RosterEntity.setGroups(user1RosterEntityGroups);

                String user1Username = new JID(item.getUser1DeviceXmppLogin()).getNode();
                String user2Username = new JID(item.getUser2DeviceXmppLogin()).getNode();

                plugin.addOrUpdateRosterItem(user1Username, user2RosterEntity);
                plugin.addOrUpdateRosterItem(user2Username, user1RosterEntity);
            } catch (ServiceException e) {
                if (e.getException() != ExceptionType.USER_NOT_FOUND_EXCEPTION && e.getException() != "RosterItemNotFound") {
                    throw new ServiceException(COULD_NOT_CREATE_ROSTER_ITEM, "", e.getMessage(),
                        Response.Status.BAD_REQUEST, e);
                }
            } catch (Exception e) {
                throw new ServiceException(COULD_NOT_CREATE_ROSTER_ITEM, "", e.getMessage(),
                    Response.Status.BAD_REQUEST, e);
            }
        }
        return Response.status(Response.Status.CREATED).build();
    }

    @DELETE
    public Response unpairUsers(List<ItemToUnpairEntity> items)
        throws ServiceException {
        for (ItemToUnpairEntity item :  items) {
            try {
                String user1Username = new JID(item.getUser1DeviceXmppLogin()).getNode();
                String user2Username = new JID(item.getUser2DeviceXmppLogin()).getNode();
                plugin.deleteRosterItem(user1Username, item.getUser2DeviceXmppLogin());
                plugin.deleteRosterItem(user2Username, item.getUser1DeviceXmppLogin());
            } catch (ServiceException e) {
                if (e.getException() != ExceptionType.USER_NOT_FOUND_EXCEPTION && e.getException() != "RosterItemNotFound") {
                    throw new ServiceException("Could not delete the roster item", "",
                        ExceptionType.SHARED_GROUP_EXCEPTION, Response.Status.BAD_REQUEST, e);
                }
            } catch (Exception e) {
                throw new ServiceException("Could not delete the roster item", "",
                    ExceptionType.SHARED_GROUP_EXCEPTION, Response.Status.BAD_REQUEST, e);
            }
        }
        return Response.status(Response.Status.OK).build();
    }

}
