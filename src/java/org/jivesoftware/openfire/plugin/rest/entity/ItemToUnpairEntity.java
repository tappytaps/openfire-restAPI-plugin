package org.jivesoftware.openfire.plugin.rest.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "item")
public class ItemToUnpairEntity {

    private String user1DeviceXmppLogin;
    private String user2DeviceXmppLogin;

    public ItemToUnpairEntity() {
    }

    public ItemToUnpairEntity(String user1DeviceXmppLogin, String user2DeviceXmppLogin) {
        this.user1DeviceXmppLogin = user1DeviceXmppLogin;
        this.user2DeviceXmppLogin = user2DeviceXmppLogin;
    }

    @XmlElement
    public String getUser1DeviceXmppLogin() {
        return user1DeviceXmppLogin;
    }

    public void setUser1DeviceXmppLogin(String user1DeviceXmppLogin) {
        this.user1DeviceXmppLogin = user1DeviceXmppLogin;
    }

    @XmlElement
    public String getUser2DeviceXmppLogin() {
        return user2DeviceXmppLogin;
    }

    public void setUser2DeviceXmppLogin(String user2DeviceXmppLogin) {
        this.user2DeviceXmppLogin = user2DeviceXmppLogin;
    }
}
