import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestCallculation {
    Callculation obj;

    @BeforeEach
    void setUp() {
        obj = new Callculation();
    }

    @Test
    @DisplayName("Testing ReadCSV")
    void test_readCsv() {
        assertEquals(true, obj.read_csv());
    }

    @Test
    @DisplayName("Testing Data Empty")
    void test_data(){
        assertFalse(obj.data_kelas().isEmpty());
    }

}
