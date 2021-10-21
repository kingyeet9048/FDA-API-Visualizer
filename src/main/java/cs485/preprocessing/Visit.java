
package cs485.preprocessing;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Visit {

    @SerializedName("treated_for_ae")
    @Expose
    private String treatedForAe;
    @SerializedName("reaction")
    @Expose
    private List<Reaction> reaction = null;
    @SerializedName("receiver")
    @Expose
    private Receiver receiver;
    @SerializedName("unique_aer_id_number")
    @Expose
    private String uniqueAerIdNumber;
    @SerializedName("original_receive_date")
    @Expose
    private String originalReceiveDate;
    @SerializedName("number_of_animals_affected")
    @Expose
    private String numberOfAnimalsAffected;
    @SerializedName("primary_reporter")
    @Expose
    private String primaryReporter;
    @SerializedName("number_of_animals_treated")
    @Expose
    private String numberOfAnimalsTreated;
    @SerializedName("drug")
    @Expose
    private List<Drug> drug = null;
    @SerializedName("health_assessment_prior_to_exposure")
    @Expose
    private HealthAssessmentPriorToExposure healthAssessmentPriorToExposure;
    @SerializedName("onset_date")
    @Expose
    private String onsetDate;
    @SerializedName("report_id")
    @Expose
    private String reportId;
    @SerializedName("animal")
    @Expose
    private Animal animal;
    @SerializedName("type_of_information")
    @Expose
    private String typeOfInformation;
    @SerializedName("serious_ae")
    @Expose
    private String seriousAe;
    @SerializedName("outcome")
    @Expose
    private List<Outcome> outcome = null;

    public String getTreatedForAe() {
        return treatedForAe;
    }

    public void setTreatedForAe(String treatedForAe) {
        this.treatedForAe = treatedForAe;
    }

    public List<Reaction> getReaction() {
        return reaction;
    }

    public void setReaction(List<Reaction> reaction) {
        this.reaction = reaction;
    }

    public Receiver getReceiver() {
        return receiver;
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    public String getUniqueAerIdNumber() {
        return uniqueAerIdNumber;
    }

    public void setUniqueAerIdNumber(String uniqueAerIdNumber) {
        this.uniqueAerIdNumber = uniqueAerIdNumber;
    }

    public String getOriginalReceiveDate() {
        return originalReceiveDate;
    }

    public void setOriginalReceiveDate(String originalReceiveDate) {
        this.originalReceiveDate = originalReceiveDate;
    }

    public String getNumberOfAnimalsAffected() {
        return numberOfAnimalsAffected;
    }

    public void setNumberOfAnimalsAffected(String numberOfAnimalsAffected) {
        this.numberOfAnimalsAffected = numberOfAnimalsAffected;
    }

    public String getPrimaryReporter() {
        return primaryReporter;
    }

    public void setPrimaryReporter(String primaryReporter) {
        this.primaryReporter = primaryReporter;
    }

    public String getNumberOfAnimalsTreated() {
        return numberOfAnimalsTreated;
    }

    public void setNumberOfAnimalsTreated(String numberOfAnimalsTreated) {
        this.numberOfAnimalsTreated = numberOfAnimalsTreated;
    }

    public List<Drug> getDrug() {
        return drug;
    }

    public void setDrug(List<Drug> drug) {
        this.drug = drug;
    }

    public HealthAssessmentPriorToExposure getHealthAssessmentPriorToExposure() {
        return healthAssessmentPriorToExposure;
    }

    public void setHealthAssessmentPriorToExposure(HealthAssessmentPriorToExposure healthAssessmentPriorToExposure) {
        this.healthAssessmentPriorToExposure = healthAssessmentPriorToExposure;
    }

    public String getOnsetDate() {
        return onsetDate;
    }

    public void setOnsetDate(String onsetDate) {
        this.onsetDate = onsetDate;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public String getTypeOfInformation() {
        return typeOfInformation;
    }

    public void setTypeOfInformation(String typeOfInformation) {
        this.typeOfInformation = typeOfInformation;
    }

    public String getSeriousAe() {
        return seriousAe;
    }

    public void setSeriousAe(String seriousAe) {
        this.seriousAe = seriousAe;
    }

    public List<Outcome> getOutcome() {
        return outcome;
    }

    public void setOutcome(List<Outcome> outcome) {
        this.outcome = outcome;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Visit.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("treatedForAe");
        sb.append('=');
        sb.append(((this.treatedForAe == null)?"<null>":this.treatedForAe));
        sb.append(',');
        sb.append("reaction");
        sb.append('=');
        sb.append(((this.reaction == null)?"<null>":this.reaction));
        sb.append(',');
        sb.append("receiver");
        sb.append('=');
        sb.append(((this.receiver == null)?"<null>":this.receiver));
        sb.append(',');
        sb.append("uniqueAerIdNumber");
        sb.append('=');
        sb.append(((this.uniqueAerIdNumber == null)?"<null>":this.uniqueAerIdNumber));
        sb.append(',');
        sb.append("originalReceiveDate");
        sb.append('=');
        sb.append(((this.originalReceiveDate == null)?"<null>":this.originalReceiveDate));
        sb.append(',');
        sb.append("numberOfAnimalsAffected");
        sb.append('=');
        sb.append(((this.numberOfAnimalsAffected == null)?"<null>":this.numberOfAnimalsAffected));
        sb.append(',');
        sb.append("primaryReporter");
        sb.append('=');
        sb.append(((this.primaryReporter == null)?"<null>":this.primaryReporter));
        sb.append(',');
        sb.append("numberOfAnimalsTreated");
        sb.append('=');
        sb.append(((this.numberOfAnimalsTreated == null)?"<null>":this.numberOfAnimalsTreated));
        sb.append(',');
        sb.append("drug");
        sb.append('=');
        sb.append(((this.drug == null)?"<null>":this.drug));
        sb.append(',');
        sb.append("healthAssessmentPriorToExposure");
        sb.append('=');
        sb.append(((this.healthAssessmentPriorToExposure == null)?"<null>":this.healthAssessmentPriorToExposure));
        sb.append(',');
        sb.append("onsetDate");
        sb.append('=');
        sb.append(((this.onsetDate == null)?"<null>":this.onsetDate));
        sb.append(',');
        sb.append("reportId");
        sb.append('=');
        sb.append(((this.reportId == null)?"<null>":this.reportId));
        sb.append(',');
        sb.append("animal");
        sb.append('=');
        sb.append(((this.animal == null)?"<null>":this.animal));
        sb.append(',');
        sb.append("typeOfInformation");
        sb.append('=');
        sb.append(((this.typeOfInformation == null)?"<null>":this.typeOfInformation));
        sb.append(',');
        sb.append("seriousAe");
        sb.append('=');
        sb.append(((this.seriousAe == null)?"<null>":this.seriousAe));
        sb.append(',');
        sb.append("outcome");
        sb.append('=');
        sb.append(((this.outcome == null)?"<null>":this.outcome));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
