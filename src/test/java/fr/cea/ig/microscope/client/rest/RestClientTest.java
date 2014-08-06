package fr.cea.ig.microscope.client.rest;

import fr.cea.ig.grools.microscope.GenomicObjectExtension;
import fr.cea.ig.grools.microscope.RestClient;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class RestClientTest {
    private RestClient mRestClient;

    @Before
    public void setUp() {
        mRestClient = new RestClient();
    }

    @Test
    public void testGetGenomicObject() {
        GenomicObjectExtension[] goArray =  mRestClient.getGenomicObject( 31 );
        assertNotNull( goArray );
        assertTrue( goArray.length > 1);
        GenomicObjectExtension go = goArray[0];
        assertTrue( go instanceof GenomicObjectExtension );
    }

    @Test
    public void test getGenomicObjectHavingPathway(){

    }

}
