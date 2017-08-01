package com.by.json;
public class ReportJson extends BaseReportJson{
	private YAxis[] yAxis;
	private Series[] series;
	public YAxis[] getyAxis() {
		return yAxis;
	}

	public void setyAxis(YAxis[] yAxis) {
		this.yAxis = yAxis;
	}

	public Series[] getSeries() {
		return series;
	}

	public void setSeries(Series[] series) {
		this.series = series;
	}

	public class Series {
		private String yAxisIndex;
		private String name;
		private String type;
		private String stack;
		private String radius = "";
		private String[] center = new String[] { "" };
		private String[] data;
		private ItemStyle itemStyle;
		
		public String getyAxisIndex() {
			return yAxisIndex;
		}

		public void setyAxisIndex(String yAxisIndex) {
			this.yAxisIndex = yAxisIndex;
		}

		public ItemStyle getItemStyle() {
			return itemStyle;
		}

		public void setItemStyle(ItemStyle itemStyle) {
			this.itemStyle = itemStyle;
		}

		public String getStack() {
			return stack;
		}

		public void setStack(String stack) {
			this.stack = stack;
		}

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

		public String[] getData() {
			return data;
		}

		public void setData(String[] data) {
			this.data = data;
		}

		public String getRadius() {
			return radius;
		}

		public void setRadius(String radius) {
			this.radius = radius;
		}

		public String[] getCenter() {
			return center;
		}

		public void setCenter(String[] center) {
			this.center = center;
		}

	}
	public class ItemStyle{
		private Normal normal;

		public Normal getNormal() {
			return normal;
		}

		public void setNormal(Normal normal) {
			this.normal = normal;
		}
		
	}
	public class Normal{
		private Label label;

		public Label getLabel() {
			return label;
		}

		public void setLabel(Label label) {
			this.label = label;
		}
		
	}
	public class Label{
		private String show;
		private String position;
		public String getShow() {
			return show;
		}
		public void setShow(String show) {
			this.show = show;
		}
		public String getPosition() {
			return position;
		}
		public void setPosition(String position) {
			this.position = position;
		}
		
	}
}
