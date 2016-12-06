/* Copyright 2016 Norconex Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.norconex.commons.wicket.markup.html.chart.jqplot.options;


/**
 * JQPlot Enhanced legend-renderer options.
 * http://www.jqplot.com/docs/files/plugins/jqplot-enhancedLegendRenderer-js.html
 * @author Pascal Essiembre
 */
public class EnhancedLegendRendererOptions implements ILegendRendererOptions {

    private static final long serialVersionUID = -5329134155086807094L;

    private Integer numberRows;
    private Integer numberColumns;
    private Boolean seriesToggle;
    private Boolean seriesToggleReplot;
    private Boolean disableIEFading;
    
    /**
     * Sets the maximum number of rows in the legend
     * @param numberRows maximum number of rows in the legend
     */
    public void setNumberRows(Integer numberRows) {
        this.numberRows = numberRows;
    }
    public Integer getNumberRows() {
        return numberRows;
    }

    /**
     * Sets the maximum number of columns in the legend.
     * @param numberColumns maximum number of columns in the legend
     */
    public void setNumberColumns(Integer numberColumns) {
        this.numberColumns = numberColumns;
    }
    public Integer getNumberColumns() {
        return numberColumns;
    }

    /**
     * Sets whether to enable series on/off toggling on the legend.
     * @param seriesToggle <code>false</code> to not enable series on/off 
     *                     toggling on the legend 
     */
    public void setSeriesToggle(Boolean seriesToggle) {
        this.seriesToggle = seriesToggle;
    }
    public Boolean getSeriesToggle() {
        return seriesToggle;
    }
    
    /**
     * Sets whether to replot the chart after toggling series on/off.
     * @param seriesToggleReplot <code>true</code> to replot the chart 
     *                           after toggling series on/off.
     */
    public void setSeriesToggleReplot(Boolean seriesToggleReplot) {
        this.seriesToggleReplot = seriesToggleReplot;
    }
    public Boolean getSeriesToggleReplot() {
        return seriesToggleReplot;
    }

    /**
     * Sets whether to to toggle series with a show/hide method only and 
     * not allow fading in/out.
     * @param disableIEFading <code>true</code> to toggle series with a 
     *                        show/hide method only and not allow fading in/out
     */
    public void setDisableIEFading(Boolean disableIEFading) {
        this.disableIEFading = disableIEFading;
    }
    public Boolean getDisableIEFading() {
        return disableIEFading;
    }

    @Override
    public String toString() {
        return new PlotToStringBuilder()
            .number("numberRows", numberRows)
            .number("numberColumns", numberColumns)
            .bool("seriesToggle", seriesToggle)
            .bool("seriesToggleReplot", seriesToggleReplot)
            .bool("disableIEFading", disableIEFading)
            .toString();
    }
}
