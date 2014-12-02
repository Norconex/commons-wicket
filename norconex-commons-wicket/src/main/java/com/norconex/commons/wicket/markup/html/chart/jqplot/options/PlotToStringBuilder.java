/* Copyright 2012-2014 Norconex Inc.
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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

/**
 * JQPlot plot builder as a string.
 * @author Pascal Essiembre
 */
@SuppressWarnings("nls")
/*default*/ final class PlotToStringBuilder {

    private final List<String> list = new ArrayList<String>();
    
    public PlotToStringBuilder() {
        super();
    }

    public PlotToStringBuilder raw(String name, Object options) {
        if (options == null) {
            return this;
        }
        String str = options.toString();
        if (str.length() <= 2) {
            return this;
        }
        list.add(name + ":" + str);
        return this;
    }
    public PlotToStringBuilder enumString(String name, Enum<?> value) {
        if (value == null) {
            return this;
        }
        list.add(name + ":'" + esc(value.toString()) + "'");
        return this;
    }
    public PlotToStringBuilder string(String name, String value) {
        if (value == null) {
            return this;
        }
        list.add(name + ":'" + esc(value) + "'");
        return this;
    }
    public PlotToStringBuilder bool(String name, Boolean value) {
        if (value == null) {
            return this;
        }
        list.add(name + ":" + value);
        return this;
    }
    public PlotToStringBuilder number(String name, Integer value) {
        if (value == null) {
            return this;
        }
        list.add(name + ":" + value);
        return this;
    }
    public PlotToStringBuilder decimal(String name, Float value) {
        if (value == null) {
            return this;
        }
        list.add(name + ":" + value);
        return this;
    }
    public PlotToStringBuilder rawList(String name, List<?> list) {
        if (list == null || list.isEmpty()) {
            return this;
        }
        return rawArray(name, list.toArray());
    }
    public PlotToStringBuilder rawArray(String name, Object[] array) {
        if (array == null) {
            return this;
        }
        StringBuilder b = new StringBuilder("[");
        for (Object object : array) {
            if (b.length() > 2) {
                b.append(", ");
            }
            b.append(Objects.toString(object,  ""));
        }
        b.append("]");
        list.add(name + ":" + b.toString());
        return this;
    }
    public PlotToStringBuilder stringList(String name, List<String> list) {
        if (list == null || list.isEmpty()) {
            return this;
        }
        StringBuilder b = new StringBuilder("[");
        for (String str : list) {
            if (b.length() > 2) {
                b.append(", ");
            }
            b.append("'");
            b.append(esc(str));
            b.append("'");
        }
        b.append("]");
        list.add(name + ":" + b.toString());
        return this;
    }
    public PlotToStringBuilder stringArray(String name, String[] array) {
        if (array == null || array.length == 0) {
            return this;
        }
        StringBuilder b = new StringBuilder("[");
        for (String str : array) {
            if (b.length() > 2) {
                b.append(", ");
            }
            b.append("'");
            b.append(esc(str));
            b.append("'");
        }
        b.append("]");
        list.add(name + ":" + b.toString());
        return this;
    }
    public PlotToStringBuilder enumArray(String name, Enum<?>[] array) {
        if (array == null || array.length == 0) {
            return this;
        }
        StringBuilder b = new StringBuilder("[");
        for (Enum<?> en : array) {
            if (b.length() > 2) {
                b.append(", ");
            }
            b.append("'");
            b.append(esc(Objects.toString(en, null)));
            b.append("'");
        }
        b.append("]");
        list.add(name + ":" + b.toString());
        return this;
    }
    
    @Override
    public String toString() {
        return "{" + StringUtils.join(list, ", ") + "}";
    }
    
    public static String esc(String str) {
        return StringUtils.replace(str, "'", "\\'");
    }
}
