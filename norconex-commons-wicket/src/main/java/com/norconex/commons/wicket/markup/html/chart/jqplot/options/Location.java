package com.norconex.commons.wicket.markup.html.chart.jqplot.options;

@SuppressWarnings("nls")
public enum Location{ 
    NORTH_WEST("nw"), 
    NORTH("n"),
    NORTH_EAST("ne"),
    EAST("e"),
    SOUTH_EAST("se"),
    SOUTH("s"),
    SOUTH_WEST("sw"),
    WEST("w");
    
    final private String abbr;
    private Location(String abbr) {
        this.abbr = abbr;
    }
    public String toString() {
        return abbr;
    };
}