/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankofhellengui;

/**
 *
 * @author Hellen Harry
 */
public class Person {
    protected String lastName;
    protected String firstName;
    protected String middleName;
    protected String Street;
    protected String city;
    protected String province;
    protected String postalCode;
    protected String dateOfBirth;
  
    protected Gender gender;
    protected String email;
    protected long phoneNumber;
    
public Person(String lastName,String firstName,String middleName,String Street,
        String city,String province,String postalCode,String dateOfBirth
        ,Gender gender,String email,long phoneNumber)
{
    this.lastName = lastName;
    this.firstName= firstName;
    this.middleName = middleName;
    this.Street = Street;
    this.city = city;
    this.province = province;
    this.postalCode = postalCode;
    this.dateOfBirth = dateOfBirth;
   
    this.gender = gender;
    this.email = email;
    this.phoneNumber = phoneNumber;
    
    
}


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String Street) {
        this.Street = Street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Person{" + "\n lastName=" + lastName + ", \n firstName=" + firstName + ", \n middleName=" + middleName + ", "
                + "\n Street=" + Street + ",\n city=" + city + "," + " "
                + "\n province=" + province + ",\n postalCode=" + postalCode + ", "
                + "\n dateOfBirth=" + dateOfBirth + ", \n gender=" + gender + ","
                + "\n email=" + email + ", \n phoneNumber=" + phoneNumber + '}';
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }



    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
            
    
}
