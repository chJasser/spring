package tn.esprit.spring.payload.request;

import tn.esprit.spring.enume.CategorieClient;
import tn.esprit.spring.enume.Profession;

import java.util.Date;
import java.util.Set;

import javax.validation.constraints.*;
public class SignupRequest {
    @NotBlank
   // @Size(min = 3, max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    private String dateNaissance;
    private Profession profession;
    private CategorieClient categorieClient;
    private Set<String> role;

    @NotBlank
   // @Size(min = 6, max = 40)
    private String password;

    @NotBlank
    // @Size(min = 3, max = 20)
    private String nom;

    @NotBlank
    // @Size(min = 3, max = 20)
    private String prenom;

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getNom() {
        return nom;
    }
    public Profession getProfession() {
        return profession;
    }
    public CategorieClient getcategorieClient() {
        return categorieClient;
    }
    public String getPrenom() {
        return prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public void setCategorieClient(CategorieClient categorieClient) {
        this.categorieClient = categorieClient;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRole() {
        return this.role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }
}