package singleton;

/**
 * User Repository
 * 
 * Singleton class to manage the user repository, implements the Lazy Holder
 * instatiation method within a Singleton.
 * 
 * @see <a href=
 *      "https://en.wikipedia.org/wiki/Initialization-on-demand_holder_idiom"
 *      >Initialization-on-demand holder idiom</a>
 * @see <a href="https://en.wikipedia.org/wiki/Lazy_initialization"
 *      >Lazy initialization</a>
 * @see <a href="https://en.wikipedia.org/wiki/Singleton_pattern"
 *      >Singleton pattern</a>
 * @author @gleidsonlm
 */
public class UserRepository {
    private UserRepository() {
        // Exists only to defeat instantiation.
        super();
    }

    private static class UserRepositoryHolder {
        private static UserRepository instance = new UserRepository();
    }

    public static UserRepository getInstance() {
        System.out.println("UserRepository is a *Singleton* example");
        return UserRepositoryHolder.instance;
    }
}
