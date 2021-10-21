
package cs485.preprocessing;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class HealthAssessmentPriorToExposure {

	@SerializedName("condition")
	@Expose
	private String condition;
	@SerializedName("assessed_by")
	@Expose
	private String assessedBy;

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getAssessedBy() {
		return assessedBy;
	}

	public void setAssessedBy(String assessedBy) {
		this.assessedBy = assessedBy;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(HealthAssessmentPriorToExposure.class.getName()).append('@')
				.append(Integer.toHexString(System.identityHashCode(this))).append('[');
		sb.append("condition");
		sb.append('=');
		sb.append(((this.condition == null) ? "<null>" : this.condition));
		sb.append(',');
		sb.append("assessedBy");
		sb.append('=');
		sb.append(((this.assessedBy == null) ? "<null>" : this.assessedBy));
		sb.append(',');
		if (sb.charAt((sb.length() - 1)) == ',') {
			sb.setCharAt((sb.length() - 1), ']');
		} else {
			sb.append(']');
		}
		return sb.toString();
	}

}
