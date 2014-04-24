package com.norconex.commons.wicket.markup.html.chart.jqplot.options;

import java.io.Serializable;


@SuppressWarnings("nls")
public class LegendOptions implements Serializable {

    private static final long serialVersionUID = 8380963445581500024L;

    public enum Placement{ insideGrid, outsideGrid, inside, outside };
    
    private Boolean show;
    private Location location;
    private Integer xoffset;
    private Integer yoffset;
    private String[] labels;
    private Placement placement;

    public Boolean getShow() {
        return show;
    }
    /**
     * Sets whether to show the legend or not.
     * @param show true to show the legend
     */
    public void setShow(Boolean show) {
        this.show = show;
    }
    public Location getLocation() {
        return location;
    }
    /**
     * Sets the compass direction (nw, n, ne, e, se, s, sw, w).
     * @param location compass direction
     */
    public void setLocation(Location location) {
        this.location = location;
    }
    public Integer getXoffset() {
        return xoffset;
    }
    /**
     * Sets the pixel offset of the legend box from the x (or x2) axis.
     * @param xoffset pixel offset of the legend box from the x (or x2) axis
     */
    public void setXoffset(Integer xoffset) {
        this.xoffset = xoffset;
    }
    public Integer getYoffset() {
        return yoffset;
    }
    /**
     * Sets the pixel offset of the legend box from the y (or y2) axis.
     * @param yoffset pixel offset of the legend box from the y (or y2) axis
     */
    public void setYoffset(Integer yoffset) {
        this.yoffset = yoffset;
    }
    public String[] getLabels() {
        return labels;
    }
    /**
     * Sets array of labels to use.  By default the renderer will look for 
     * labels on the series.  Labels specified in this array will override 
     * labels specified on the series.
     * @param labels labels to use
     */
    public void setLabels(String... labels) {
        this.labels = labels;
    }
    public Placement getPlacement() {
        return placement;
    }
    /**
     * Sets the legend placement in relation to the grid. 
     * �?insideGrid�? places legend inside the grid 
     * area of the plot. “outsideGrid�? places the legend outside the grid but 
     * inside the plot container, shrinking the grid to accommodate the legend.
     * “inside�? synonym for “insideGrid�?, “outside�? places the legend outside 
     * the grid area, but does not shrink the grid which can cause the legend 
     * to overflow the plot container.
     * @param placement the legend placement
     */
    public void setPlacement(Placement placement) {
        this.placement = placement;
    }
    @Override
    public String toString() {
        return new PlotToStringBuilder()
            .bool("show", show)
            .enumString("location", location)
            .integer("xoffset", xoffset)
            .integer("yoffset", yoffset)
            .stringArray("labels", labels)
            .enumString("placement", placement)
            .toString();
    }
}