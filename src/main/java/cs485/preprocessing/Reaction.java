
package cs485.preprocessing;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Reaction {

	@SerializedName("veddra_version")
	@Expose
	private String veddraVersion;
	@SerializedName("veddra_term_code")
	@Expose
	private String veddraTermCode;
	@SerializedName("veddra_term_name")
	@Expose
	private String veddraTermName;
	@SerializedName("number_of_animals_affected")
	@Expose
	private String numberOfAnimalsAffected;
	@SerializedName("accuracy")
	@Expose
	private String accuracy;

	public String getVeddraVersion() {
		return veddraVersion;
	}

	public void setVeddraVersion(String veddraVersion) {
		this.veddraVersion = veddraVersion;
	}

	public String getVeddraTermCode() {
		return veddraTermCode;
	}

	public void setVeddraTermCode(String veddraTermCode) {
		this.veddraTermCode = veddraTermCode;
	}

	public String getVeddraTermName() {
		return veddraTermName;
	}

	public void setVeddraTermName(String veddraTermName) {
		this.veddraTermName = veddraTermName;
	}

	public String getNumberOfAnimalsAffected() {
		return numberOfAnimalsAffected;
	}

	public void setNumberOfAnimalsAffected(String numberOfAnimalsAffected) {
		this.numberOfAnimalsAffected = numberOfAnimalsAffected;
	}

	public String getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(String accuracy) {
		this.accuracy = accuracy;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(Reaction.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
				.append('[');
		sb.append("veddraVersion");
		sb.append('=');
		sb.append(((this.veddraVersion == null) ? "<null>" : this.veddraVersion));
		sb.append(',');
		sb.append("veddraTermCode");
		sb.append('=');
		sb.append(((this.veddraTermCode == null) ? "<null>" : this.veddraTermCode));
		sb.append(',');
		sb.append("veddraTermName");
		sb.append('=');
		sb.append(((this.veddraTermName == null) ? "<null>" : this.veddraTermName));
		sb.append(',');
		sb.append("numberOfAnimalsAffected");
		sb.append('=');
		sb.append(((this.numberOfAnimalsAffected == null) ? "<null>" : this.numberOfAnimalsAffected));
		sb.append(',');
		sb.append("accuracy");
		sb.append('=');
		sb.append(((this.accuracy == null) ? "<null>" : this.accuracy));
		sb.append(',');
		if (sb.charAt((sb.length() - 1)) == ',') {
			sb.setCharAt((sb.length() - 1), ']');
		} else {
			sb.append(']');
		}
		return sb.toString();
	}

}
