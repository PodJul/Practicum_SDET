package tests.api.tests;

import helpers.Specification;
import org.junit.Before;

public class SetupTest {
    @Before
    public void setUp() {
        Specification.installSpec(Specification.requestSpec("http://localhost:8080/", "api"), Specification.responseSpec());

    }
}
