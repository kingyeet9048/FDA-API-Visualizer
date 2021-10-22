
package cs485.preprocessing;

import java.util.Objects;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Receiver {

	@SerializedName("organization")
	@Expose
	private String organization;
	@SerializedName("street_address")
	@Expose
	private String streetAddress;
	@SerializedName("city")
	@Expose
	private String city;
	@SerializedName("state")
	@Expose
	private String state;
	@SerializedName("postal_code")
	@Expose
	private String postalCode;
	@SerializedName("country")
	@Expose
	private String country;

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(Receiver.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
				.append('[');
		sb.append("organization");
		sb.append('=');
		sb.append(((this.organization == null) ? "<null>" : this.organization));
		sb.append(',');
		sb.append("streetAddress");
		sb.append('=');
		sb.append(((this.streetAddress == null) ? "<null>" : this.streetAddress));
		sb.append(',');
		sb.append("city");
		sb.append('=');
		sb.append(((this.city == null) ? "<null>" : this.city));
		sb.append(',');
		sb.append("state");
		sb.append('=');
		sb.append(((this.state == null) ? "<null>" : this.state));
		sb.append(',');
		sb.append("postalCode");
		sb.append('=');
		sb.append(((this.postalCode == null) ? "<null>" : this.postalCode));
		sb.append(',');
		sb.append("country");
		sb.append('=');
		sb.append(((this.country == null) ? "<null>" : this.country));
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
		return Objects.hash(city, country, organization, postalCode, state, streetAddress);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Receiver other = (Receiver) obj;
		return Objects.equals(city, other.city) && Objects.equals(country, other.country)
				&& Objects.equals(organization, other.organization) && Objects.equals(postalCode, other.postalCode)
				&& Objects.equals(state, other.state) && Objects.equals(streetAddress, other.streetAddress);
	}

}
