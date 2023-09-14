package com.ns.springboothibernateenvers.service;

import com.ns.springboothibernateenvers.entity.User;
import com.ns.springboothibernateenvers.repository.UserRepository;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.query.AuditEntity;
import org.hibernate.envers.query.AuditQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final AuditReader auditReader;

    public UserService(UserRepository userRepository, AuditReader auditReader) {
        this.userRepository = userRepository;
        this.auditReader = auditReader;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Integer userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public User updateUser(Integer userId, User user) {
        Optional<User> userToUpdate = userRepository.findById(userId);
        if (userToUpdate.isPresent()) {
            User updatedUser = userToUpdate.get();
            updatedUser.setFirstName(user.getFirstName());
            updatedUser.setLastName(user.getLastName());
            userRepository.save(updatedUser);
            return updatedUser;
        }
        return null;
    }

    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }

    public List<Object> getAllRevisionsByUserId(Integer userId) {
        AuditQuery q = auditReader.createQuery().forRevisionsOfEntity(User.class, false, true);
        q.add(AuditEntity.id().eq(userId));
        List audit = q.getResultList();
        audit.forEach(System.out::println);
        return audit;
    }

    public List<User> getUsersByRevision(Integer revisionNumber) {
        AuditQuery q = auditReader.createQuery().forRevisionsOfEntity(User.class, true, true);
        q.add(AuditEntity.revisionNumber().eq(revisionNumber));
        List audit = q.getResultList();
        audit.forEach(System.out::println);
        return audit;
    }

    public List<User> getUsersAtRevision(Integer revisionNumber) {
        AuditQuery q = auditReader.createQuery().forEntitiesAtRevision(User.class, revisionNumber);
//        q.add(AuditEntity.property("lastName").ilike("Tarasevych", MatchMode.ANYWHERE));
        q.addOrder(AuditEntity.property("firstName").asc());
        List<User> audit = q.getResultList();
        audit.forEach(System.out::println);
        return audit;
    }
}
