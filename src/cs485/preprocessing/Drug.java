
package cs485.preprocessing;

import java.util.List;
import java.util.Objects;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Drug {

	@SerializedName("first_exposure_date")
	@Expose
	private String firstExposureDate;
	@SerializedName("last_exposure_date")
	@Expose
	private String lastExposureDate;
	@SerializedName("administered_by")
	@Expose
	private String administeredBy;
	@SerializedName("route")
	@Expose
	private String route;
	@SerializedName("used_according_to_label")
	@Expose
	private String usedAccordingToLabel;
	@SerializedName("ae_abated_after_stopping_drug")
	@Expose
	private String aeAbatedAfterStoppingDrug;
	@SerializedName("lot_number")
	@Expose
	private String lotNumber;
	@SerializedName("lot_expiration")
	@Expose
	private String lotExpiration;
	@SerializedName("brand_name")
	@Expose
	private String brandName;
	@SerializedName("dosage_form")
	@Expose
	private String dosageForm;
	@SerializedName("manufacturer")
	@Expose
	private Manufacturer manufacturer;
	@SerializedName("atc_vet_code")
	@Expose
	private String atcVetCode;
	@SerializedName("active_ingredients")
	@Expose
	private List<ActiveIngredient> activeIngredients = null;

	public String getFirstExposureDate() {
		return firstExposureDate;
	}

	public void setFirstExposureDate(String firstExposureDate) {
		this.firstExposureDate = firstExposureDate;
	}

	public String getLastExposureDate() {
		return lastExposureDate;
	}

	public void setLastExposureDate(String lastExposureDate) {
		this.lastExposureDate = lastExposureDate;
	}

	public String getAdministeredBy() {
		return administeredBy;
	}

	public void setAdministeredBy(String administeredBy) {
		this.administeredBy = administeredBy;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getUsedAccordingToLabel() {
		return usedAccordingToLabel;
	}

	public void setUsedAccordingToLabel(String usedAccordingToLabel) {
		this.usedAccordingToLabel = usedAccordingToLabel;
	}

	public String getAeAbatedAfterStoppingDrug() {
		return aeAbatedAfterStoppingDrug;
	}

	public void setAeAbatedAfterStoppingDrug(String aeAbatedAfterStoppingDrug) {
		this.aeAbatedAfterStoppingDrug = aeAbatedAfterStoppingDrug;
	}

	public String getLotNumber() {
		return lotNumber;
	}

	public void setLotNumber(String lotNumber) {
		this.lotNumber = lotNumber;
	}

	public String getLotExpiration() {
		return lotExpiration;
	}

	public void setLotExpiration(String lotExpiration) {
		this.lotExpiration = lotExpiration;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getDosageForm() {
		return dosageForm;
	}

	public void setDosageForm(String dosageForm) {
		this.dosageForm = dosageForm;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getAtcVetCode() {
		return atcVetCode;
	}

	public void setAtcVetCode(String atcVetCode) {
		this.atcVetCode = atcVetCode;
	}

	public List<ActiveIngredient> getActiveIngredients() {
		return activeIngredients;
	}

	public void setActiveIngredients(List<ActiveIngredient> activeIngredients) {
		this.activeIngredients = activeIngredients;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(Drug.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
				.append('[');
		sb.append("firstExposureDate");
		sb.append('=');
		sb.append(((this.firstExposureDate == null) ? "<null>" : this.firstExposureDate));
		sb.append(',');
		sb.append("lastExposureDate");
		sb.append('=');
		sb.append(((this.lastExposureDate == null) ? "<null>" : this.lastExposureDate));
		sb.append(',');
		sb.append("administeredBy");
		sb.append('=');
		sb.append(((this.administeredBy == null) ? "<null>" : this.administeredBy));
		sb.append(',');
		sb.append("route");
		sb.append('=');
		sb.append(((this.route == null) ? "<null>" : this.route));
		sb.append(',');
		sb.append("usedAccordingToLabel");
		sb.append('=');
		sb.append(((this.usedAccordingToLabel == null) ? "<null>" : this.usedAccordingToLabel));
		sb.append(',');
		sb.append("aeAbatedAfterStoppingDrug");
		sb.append('=');
		sb.append(((this.aeAbatedAfterStoppingDrug == null) ? "<null>" : this.aeAbatedAfterStoppingDrug));
		sb.append(',');
		sb.append("lotNumber");
		sb.append('=');
		sb.append(((this.lotNumber == null) ? "<null>" : this.lotNumber));
		sb.append(',');
		sb.append("lotExpiration");
		sb.append('=');
		sb.append(((this.lotExpiration == null) ? "<null>" : this.lotExpiration));
		sb.append(',');
		sb.append("brandName");
		sb.append('=');
		sb.append(((this.brandName == null) ? "<null>" : this.brandName));
		sb.append(',');
		sb.append("dosageForm");
		sb.append('=');
		sb.append(((this.dosageForm == null) ? "<null>" : this.dosageForm));
		sb.append(',');
		sb.append("manufacturer");
		sb.append('=');
		sb.append(((this.manufacturer == null) ? "<null>" : this.manufacturer));
		sb.append(',');
		sb.append("atcVetCode");
		sb.append('=');
		sb.append(((this.atcVetCode == null) ? "<null>" : this.atcVetCode));
		sb.append(',');
		sb.append("activeIngredients");
		sb.append('=');
		sb.append(((this.activeIngredients == null) ? "<null>" : this.activeIngredients));
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
		return Objects.hash(activeIngredients, administeredBy, aeAbatedAfterStoppingDrug, atcVetCode, brandName,
				dosageForm, firstExposureDate, lastExposureDate, lotExpiration, lotNumber, manufacturer, route,
				usedAccordingToLabel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Drug other = (Drug) obj;
		return Objects.equals(activeIngredients, other.activeIngredients)
				&& Objects.equals(administeredBy, other.administeredBy)
				&& Objects.equals(aeAbatedAfterStoppingDrug, other.aeAbatedAfterStoppingDrug)
				&& Objects.equals(atcVetCode, other.atcVetCode) && Objects.equals(brandName, other.brandName)
				&& Objects.equals(dosageForm, other.dosageForm)
				&& Objects.equals(firstExposureDate, other.firstExposureDate)
				&& Objects.equals(lastExposureDate, other.lastExposureDate)
				&& Objects.equals(lotExpiration, other.lotExpiration) && Objects.equals(lotNumber, other.lotNumber)
				&& Objects.equals(manufacturer, other.manufacturer) && Objects.equals(route, other.route)
				&& Objects.equals(usedAccordingToLabel, other.usedAccordingToLabel);
	}

}
