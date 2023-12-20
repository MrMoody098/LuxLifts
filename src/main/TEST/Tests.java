
import App.Authentication.Auth;
import App.DataTypes.Passenger;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.sql.SQLOutput;

import static org.junit.jupiter.api.Assertions.*;

class Tests {

    @Before
    public void setUp() {

    }
    //AUTH TESTS
    @Test
    public void testLoginSuccessful() {
        // Test case for successful login
        Passenger passenger = Auth.login("testUser", "testPassword");
        Passenger passenger2 = Auth.login("JOHNNYYY12233@", "testPassword");
        assertNotNull(passenger);
        //if the passenger has a username then it has been successfully returned from Auth.login and logged in
        //our passenger
        assertEquals("testUser", passenger.GetUsername());
        assertEquals("JOHNNYYY12233@",passenger2);
    }

    @Test
    public void testLoginFailed() {
        // Test case for failed login (incorrect password)
        Passenger passenger = Auth.login("testUser", "wrongPassword");
        assertNull(passenger);
    }

    @Test
    public void testSignupSuccessful() {
        // Test case for successful signup
        try {
            Passenger passenger = Auth.login("newUser", "newPassword");
            assertNotNull(passenger);
            assertEquals("newUser", passenger.GetUsername());

        } catch (Exception e) {
            fail("UserNameNotFound");
            System.out.println("User Name Not Found");
        }
    }
        @Test
    public void testSignupUsernameExists() {
        // Test case for signup with an existing username
        try {
            Passenger passenger = Auth.signup("testUser", "newPassword");
            assertNull(passenger); // Username already exists, signup should fail
        } catch (FileNotFoundException e) {
            fail("FileNotFoundException not expected during signup");
        }
    }
}