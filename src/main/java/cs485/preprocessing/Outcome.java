
package cs485.preprocessing;

import java.util.Objects;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Outcome {

	@SerializedName("medical_status")
	@Expose
	private String medicalStatus;
	@SerializedName("number_of_animals_affected")
	@Expose
	private String numberOfAnimalsAffected;

	public String getMedicalStatus() {
		return medicalStatus;
	}

	public void setMedicalStatus(String medicalStatus) {
		this.medicalStatus = medicalStatus;
	}

	public String getNumberOfAnimalsAffected() {
		return numberOfAnimalsAffected;
	}

	public void setNumberOfAnimalsAffected(String numberOfAnimalsAffected) {
		this.numberOfAnimalsAffected = numberOfAnimalsAffected;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(Outcome.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
				.append('[');
		sb.append("medicalStatus");
		sb.append('=');
		sb.append(((this.medicalStatus == null) ? "<null>" : this.medicalStatus));
		sb.append(',');
		sb.append("numberOfAnimalsAffected");
		sb.append('=');
		sb.append(((this.numberOfAnimalsAffected == null) ? "<null>" : this.numberOfAnimalsAffected));
		sb.append(',');
		if (sb.charAt((sb.length() - 1)) == ',') {
			sb.setCharAt((sb.length() - 1), ']');
		} else {
			sb.append(']');
		}
		return sb.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(medicalStatus, numberOfAnimalsAffected);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Outcome other = (Outcome) obj;
		return Objects.equals(medicalStatus, other.medicalStatus)
				&& Objects.equals(numberOfAnimalsAffected, other.numberOfAnimalsAffected);
	}

}
