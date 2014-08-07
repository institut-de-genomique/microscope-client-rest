package fr.cea.ig.microscope.client.rest;

import fr.cea.ig.microscope.client.model.GenomicObjectExtension;
import fr.cea.ig.microscope.client.model.GoReaction;
import fr.cea.ig.microscope.client.model.Organism;
import fr.cea.ig.microscope.client.rest.RestClient;
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
    public void testGetGenomicObjects() {
        GenomicObjectExtension[] goArray = mRestClient.getGenomicObjects(31);
        assertNotNull(goArray);
        assertTrue(goArray.length > 1);
        GenomicObjectExtension go = goArray[0];
        assertTrue(go instanceof GenomicObjectExtension);
    }

    @Test
    public void testGetGenomicObjectHavingPathway() {

    }

    @Test
    public void testGetetOrganism() {
    }

    @Test
    public void testGetOrganisms() {
    }

    @Test
    public void testGetNcbiTaxon() {
    }

    @Test
    public void testGetMicroscopeTaxon() {
    }

    @Test
    public void testGetReactions() {
    }

    @Test
    public void testGetReaction() {

    }
}
