package org.jivesoftware.openfire.plugin.rest.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class ItemToPairEntity {

    private String user1DeviceXmppLogin;
    private String user2DeviceXmppLogin;
    private String user1DeviceName;
    private String user2DeviceName;
    private String user1GroupName;
    private String user2GroupName;

    public ItemToPairEntity() {
    }

    public ItemToPairEntity(String user1DeviceXmppLogin, String user2DeviceXmppLogin, String user1DeviceName, String user2DeviceName, String user1GroupName, String user2GroupName) {
        this.user1DeviceXmppLogin = user1DeviceXmppLogin;
        this.user2DeviceXmppLogin = user2DeviceXmppLogin;
        this.user1DeviceName = user1DeviceName;
        this.user2DeviceName = user2DeviceName;
        this.user1GroupName = user1GroupName;
        this.user2GroupName = user2GroupName;
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

    @XmlElement
    public String getUser1DeviceName() {
        return user1DeviceName;
    }

    public void setUser1DeviceName(String user1DeviceName) {
        this.user1DeviceName = user1DeviceName;
    }

    @XmlElement
    public String getUser2DeviceName() {
        return user2DeviceName;
    }

    public void setUser2DeviceName(String user2DeviceName) {
        this.user2DeviceName = user2DeviceName;
    }

    @XmlElement
    public String getUser1GroupName() {
        return user1GroupName;
    }

    public void setUser1GroupName(String user1GroupName) {
        this.user1GroupName = user1GroupName;
    }

    @XmlElement
    public String getUser2GroupName() {
        return user2GroupName;
    }

    public void setUser2GroupName(String user2GroupName) {
        this.user2GroupName = user2GroupName;
    }
}
