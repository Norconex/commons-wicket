package com.norconex.commons.wicket.examples.table;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

public class SortableContactDataProvider 
        extends SortableDataProvider<Contact, String> {

    private static final long serialVersionUID = 1L;

    private final List<Contact> contacts = Arrays.asList(
            new Contact("Didier", "Drogba"),
            new Contact("Ignacio", "Piatti"),
            new Contact("Laurent", "Ciman"),
            new Contact("Dominic", "Oduro"),
            new Contact("Kyle", "Bekker"),
            new Contact("Hernán", "Bernardello"),
            new Contact("Patrice", "Bernier"),
            new Contact("Evan", "Bush"),
            new Contact("Hassoun", "Camara"),
            new Contact("Marco", "Donadel"),
            new Contact("Wandrille", "Lefèvre"),
            new Contact("Harry", "Shipp"),
            new Contact("Donny", "Toia")
            );
    
    private final ContactComparator contactComparator = new ContactComparator();
    
    public SortableContactDataProvider() {
        setSort("firstName", SortOrder.ASCENDING);
    }

    @Override
    public Iterator<? extends Contact> iterator(long first, long count) {
        Collections.sort(contacts, contactComparator);
        return contacts.subList((int) first, (int) (first + count)).iterator();
    }
    
    @Override
    public IModel<Contact> model(Contact object) {
        return new Model<>(object);
    }
    @Override
    public long size() {
        return contacts.size();
    }
    
    
    class ContactComparator implements Comparator<Contact>, Serializable  {
        private static final long serialVersionUID = -8985219494281889461L;

        @Override
        public int compare(Contact c1, Contact c2) {
            int val = 0;
            if ("firstName".equals(getSort().getProperty())) {
                val = c1.getFirstName().compareTo(c2.getFirstName());
            } else {
                val = c1.getLastName().compareTo(c2.getLastName());
            }
            if (!getSort().isAscending()) {
                val *= -1;
            }
            return val;
        }
    };
    
}
