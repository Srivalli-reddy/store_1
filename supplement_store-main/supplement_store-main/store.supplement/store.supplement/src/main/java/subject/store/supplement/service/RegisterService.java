package subject.store.supplement.service;

import subject.store.supplement.entities.User;

public interface RegisterService {
    void register(User user);
    boolean isUsernameTaken(String username);
}
