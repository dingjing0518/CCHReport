package com.by.json;

public class BaseReportJson {

	private Tooltip tooltip;
	private Legend legend;
	private XAxis xAxis;
	private Grid grid;
	
	public Grid getGrid() {
		return grid;
	}

	public void setGrid(Grid grid) {
		this.grid = grid;
	}

	public Legend getLegend() {
		return legend;
	}

	public void setLegend(Legend legend) {
		this.legend = legend;
	}

	public XAxis getxAxis() {
		return xAxis;
	}

	public void setxAxis(XAxis xAxis) {
		this.xAxis = xAxis;
	}

	public Tooltip getTooltip() {
		return tooltip;
	}

	public void setTooltip(Tooltip tooltip) {
		this.tooltip = tooltip;
	}
	public class Title {
		private String text;
		private String subtext="";
		private String right;

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

		public String getSubtext() {
			return subtext;
		}

		public void setSubtext(String subtext) {
			this.subtext = subtext;
		}

		public String getRight() {
			return right;
		}

		public void setRight(String right) {
			this.right = right;
		}
		
	}

	public class Tooltip {
		private String show = "true";
		private String trigger;
		private String formatter = "";

		public String getShow() {
			return show;
		}

		public void setShow(String show) {
			this.show = show;
		}

		public String getTrigger() {
			return trigger;
		}

		public void setTrigger(String trigger) {
			this.trigger = trigger;
		}

		public String getFormatter() {
			return formatter;
		}

		public void setFormatter(String formatter) {
			this.formatter = formatter;
		}
		}

	public class Legend {
		private String x;
		private String y;
		private Integer itemGap;
		private String[] data;
		private String show;
		private String orient;
		private String bottom;
		
		
		public String getBottom() {
			return bottom;
		}

		public void setBottom(String bottom) {
			this.bottom = bottom;
		}

		public String getOrient() {
			return orient;
		}

		public void setOrient(String orient) {
			this.orient = orient;
		}

		public String getShow() {
			return show;
		}

		public void setShow(String show) {
			this.show = show;
		}

		public String getX() {
			return x;
		}

		public void setX(String x) {
			this.x = x;
		}

		public String getY() {
			return y;
		}

		public void setY(String y) {
			this.y = y;
		}

		public Integer getItemGap() {
			return itemGap;
		}

		public void setItemGap(Integer itemGap) {
			this.itemGap = itemGap;
		}

		public String[] getData() {
			return data;
		}

		public void setData(String[] data) {
			this.data = data;
		}
	}

	public class XAxis {
		private String type;
		private String show;
		private String name;
		private String[] data;

		public String[] getData() {
			return data;
		}

		public void setData(String[] data) {
			this.data = data;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getShow() {
			return show;
		}

		public void setShow(String show) {
			this.show = show;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
	}

	public class YAxis {
		private String name;
		private String type;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}
		
	}
	public class Grid{
		private String left;
		private String  containLabel;
		
		public String getLeft() {
			return left;
		}
		public void setLeft(String left) {
			this.left = left;
		}
		public String getContainLabel() {
			return containLabel;
		}
		public void setContainLabel(String containLabel) {
			this.containLabel = containLabel;
		}
		
	}
}
