
package cs485.preprocessing;

import java.util.Objects;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Dose {

	@SerializedName("numerator")
	@Expose
	private String numerator;
	@SerializedName("numerator_unit")
	@Expose
	private String numeratorUnit;
	@SerializedName("denominator")
	@Expose
	private String denominator;
	@SerializedName("denominator_unit")
	@Expose
	private String denominatorUnit;

	public String getNumerator() {
		return numerator;
	}

	public void setNumerator(String numerator) {
		this.numerator = numerator;
	}

	public String getNumeratorUnit() {
		return numeratorUnit;
	}

	public void setNumeratorUnit(String numeratorUnit) {
		this.numeratorUnit = numeratorUnit;
	}

	public String getDenominator() {
		return denominator;
	}

	public void setDenominator(String denominator) {
		this.denominator = denominator;
	}

	public String getDenominatorUnit() {
		return denominatorUnit;
	}

	public void setDenominatorUnit(String denominatorUnit) {
		this.denominatorUnit = denominatorUnit;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(Dose.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
				.append('[');
		sb.append("numerator");
		sb.append('=');
		sb.append(((this.numerator == null) ? "<null>" : this.numerator));
		sb.append(',');
		sb.append("numeratorUnit");
		sb.append('=');
		sb.append(((this.numeratorUnit == null) ? "<null>" : this.numeratorUnit));
		sb.append(',');
		sb.append("denominator");
		sb.append('=');
		sb.append(((this.denominator == null) ? "<null>" : this.denominator));
		sb.append(',');
		sb.append("denominatorUnit");
		sb.append('=');
		sb.append(((this.denominatorUnit == null) ? "<null>" : this.denominatorUnit));
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
		return Objects.hash(denominator, denominatorUnit, numerator, numeratorUnit);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dose other = (Dose) obj;
		return Objects.equals(denominator, other.denominator) && Objects.equals(denominatorUnit, other.denominatorUnit)
				&& Objects.equals(numerator, other.numerator) && Objects.equals(numeratorUnit, other.numeratorUnit);
	}

}
