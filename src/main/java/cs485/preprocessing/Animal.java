
package cs485.preprocessing;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Animal {

	@SerializedName("species")
	@Expose
	private String species;
	@SerializedName("gender")
	@Expose
	private String gender;
	@SerializedName("reproductive_status")
	@Expose
	private String reproductiveStatus;
	@SerializedName("female_animal_physiological_status")
	@Expose
	private String femaleAnimalPhysiologicalStatus;
	@SerializedName("age")
	@Expose
	private Age age;
	@SerializedName("weight")
	@Expose
	private Weight weight;

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getReproductiveStatus() {
		return reproductiveStatus;
	}

	public void setReproductiveStatus(String reproductiveStatus) {
		this.reproductiveStatus = reproductiveStatus;
	}

	public String getFemaleAnimalPhysiologicalStatus() {
		return femaleAnimalPhysiologicalStatus;
	}

	public void setFemaleAnimalPhysiologicalStatus(String femaleAnimalPhysiologicalStatus) {
		this.femaleAnimalPhysiologicalStatus = femaleAnimalPhysiologicalStatus;
	}

	public Age getAge() {
		return age;
	}

	public void setAge(Age age) {
		this.age = age;
	}

	public Weight getWeight() {
		return weight;
	}

	public void setWeight(Weight weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(Animal.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
				.append('[');
		sb.append("species");
		sb.append('=');
		sb.append(((this.species == null) ? "<null>" : this.species));
		sb.append(',');
		sb.append("gender");
		sb.append('=');
		sb.append(((this.gender == null) ? "<null>" : this.gender));
		sb.append(',');
		sb.append("reproductiveStatus");
		sb.append('=');
		sb.append(((this.reproductiveStatus == null) ? "<null>" : this.reproductiveStatus));
		sb.append(',');
		sb.append("femaleAnimalPhysiologicalStatus");
		sb.append('=');
		sb.append(((this.femaleAnimalPhysiologicalStatus == null) ? "<null>" : this.femaleAnimalPhysiologicalStatus));
		sb.append(',');
		sb.append("age");
		sb.append('=');
		sb.append(((this.age == null) ? "<null>" : this.age));
		sb.append(',');
		sb.append("weight");
		sb.append('=');
		sb.append(((this.weight == null) ? "<null>" : this.weight));
		sb.append(',');
		if (sb.charAt((sb.length() - 1)) == ',') {
			sb.setCharAt((sb.length() - 1), ']');
		} else {
			sb.append(']');
		}
		return sb.toString();
	}

}
