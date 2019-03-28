package org.jivesoftware.openfire.plugin.rest.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.jackson.annotate.JsonProperty;
import org.jivesoftware.openfire.plugin.rest.entity.ItemToUnpairEntity;
/**
 * The Class ItemsToUnpairContainer.
 */
@XmlRootElement(name = "items")
@XmlType(propOrder = { "items" })
public class ItemToUnpairEntities {

    /** The groups. */
    private List<ItemToUnpairEntity> items;


    /**
     * Instantiates a new roster item entity.
     */
    public ItemToUnpairEntities(List<ItemToUnpairEntity> items) {
        this.items = items;

    }

    /**
     * Gets items.
     *
     * @return the items
     */
    @XmlElement(name = "items")
    @JsonProperty(value = "items")
    public List<ItemToUnpairEntity> getItems() {
        return items;
    }

    /**
     * Sets items.
     *
     * @param items
     *            the new items
     */
    public void setItems(List<ItemToUnpairEntity> items) {
        this.items = items;
    }
}
