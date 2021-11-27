package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entity.Role;
import tn.esprit.spring.entity.User;
@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
    @Query("SELECT r FROM Role r WHERE r.nomRole='admin' ")
    public Role getRoleAdmin();
    @Query("SELECT r FROM Role r WHERE r.nomRole='client' ")
    public Role getRoleClient();
}
