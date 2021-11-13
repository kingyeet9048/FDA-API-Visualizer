
package cs485.preprocessing;

import java.util.Objects;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class ActiveIngredient {

	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("dose")
	@Expose
	private Dose dose;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Dose getDose() {
		return dose;
	}

	public void setDose(Dose dose) {
		this.dose = dose;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(ActiveIngredient.class.getName()).append('@')
				.append(Integer.toHexString(System.identityHashCode(this))).append('[');
		sb.append("name");
		sb.append('=');
		sb.append(((this.name == null) ? "<null>" : this.name));
		sb.append(',');
		sb.append("dose");
		sb.append('=');
		sb.append(((this.dose == null) ? "<null>" : this.dose));
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
		return Objects.hash(dose, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ActiveIngredient other = (ActiveIngredient) obj;
		return Objects.equals(dose, other.dose) && Objects.equals(name, other.name);
	}

}
