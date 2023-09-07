package org.zan.tranferservice.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RandomStringTest {

    @Test
    public void testGenerateUniqueReferenceId() {
        String id1 = RandomString.generateUniqueReferenceId();
        String id2 = RandomString.generateUniqueReferenceId();

        assertNotNull(id1);
        assertNotNull(id2);
        assertNotEquals(id1, id2);

        assertEquals(13, id1.length());
        assertEquals(13, id2.length());

        assertTrue(id1.matches("^[a-zA-Z0-9]*$"));
        assertTrue(id2.matches("^[a-zA-Z0-9]*$"));
    }
}
