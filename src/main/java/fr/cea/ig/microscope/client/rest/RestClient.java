package fr.cea.ig.microscope.client.rest;

import org.springframework.web.client.RestTemplate;

import java.net.URI;

public class RestClient {

    public static final String GET_GENOMIC_OBJECTS                  = "/api/microscope/genomes/genomic-objects/list-from-organism/{oId}";
    public static final String GET_GENOMIC_OBJECTS_HAVING_PATHWAY   = "/api/microscope/genomes/genomic-objects/list-from-pgdb-frame/{pgdbFrame}";
    public static final String GET_ORGANISM                         = "/api/microscope/organisms/{oId}";
    public static final String GET_ORGANISMS                        = "/api/microscope/organisms/list";
    public static final String GET_NCBI_TAXON                       = "/api/microscope/organisms/m2n/{oId}";
    public static final String GET_MICROSCOPE_TAXON                 = "/api/microscope/organisms/n2m/{taxon}";
    public static final String GET_REACTIONS                        = "/api/microscope/networks/reactions/list";
    public static final String GET_REACTION_FROM_GENE               = "/api/microscope/networks/reactions/gene-reactions/{goOriId}";
    public static final String GET_METACYC_REACTION_FROM_GENE       = "/api/microscope/networks/reactions/microcyc/gene-reactions/{goOriId} ";
    public static final String GET_RHEA_REACTION_FROM_GENE          = "/api/microscope/networks/reactions/rhea/gene-reactions/{goOriId}";
    public static final String GET_METACYC_REACTIONS_FROM_ORGANISM  = "/api/microscope/networks/microcyc/reactions/list/{oId}";
    public static final String GET_METACYC_PATHWAY                  = "/api/microscope/networks/microcyc/pathways/list/{oId}";
    public static final String GET_GENE_FROM_METACYC_ORGANISM       = "/api/microscope/networks/microcyc/genes/{oId}";
    public static final String GET_METACYC_REACTION_FROM_ID         = "/api/microscope/networks/microcyc/reactions/get/{mrId}";
    public static final String GET_METACYC_REACTIONS                = "/api/microscope/networks/microcyc/reactions/list/";
    public static final String GET_RHEA_REACTIONS_FROM_ORGANISM     = "/api/microscope/networks/rhea/reactions/list/{oId}";
    public static final String GET_ORGANISM_GENES_FROM_RHEA         = "/api/microscope/networks/rhea/genes/{oId}";

    private static final URI SERVER_URI = getURI("http://mgalileo.genoscope.cns.fr");
    private static URI getURI(final String uri ){
        URI item;
        try{
            item = new URI( uri);
        }catch(final Exception ex){
            throw new RuntimeException("Failed to create ObjectName instance in static block.",ex);
        }
        return item;
    }

    private RestTemplate mRestTemplate;

    public RestClient(){
        mRestTemplate = new RestTemplate();
    }


    public GenomicObjectExtension[] getGenomicObject( final int oId ){
        return mRestTemplate.getForEntity( SERVER_URI+GET_GENOMIC_OBJECTS, GenomicObjectExtension[].class, oId).getBody();
    }

    public GenomicObject getGenomicObjectHavingPathway( final int pathwayId ){
        return mRestTemplate.getForObject( SERVER_URI+GET_GENOMIC_OBJECTS_HAVING_PATHWAY, GenomicObject.class, pathwayId);
    }

    public Organism getOrganism( final int oId ){
        return mRestTemplate.getForObject( SERVER_URI+GET_ORGANISM, Organism.class, oId);
    }

    public Organism[] getOrganisms( ) {
        return mRestTemplate.getForEntity( SERVER_URI + GET_ORGANISMS, Organism[].class ).getBody();
    }

    public Integer getNcbiTaxon( final int oId ){
        return mRestTemplate.getForObject( SERVER_URI+GET_NCBI_TAXON, Integer.class, oId);
    }

    public Integer getMicroscopeTaxon( final int ncbiId ){
        return mRestTemplate.getForObject( SERVER_URI+GET_MICROSCOPE_TAXON, Integer.class, ncbiId);
    }

    public GoReaction[] GetReactions() {
        return mRestTemplate.getForEntity(SERVER_URI + GET_REACTIONS, GoReaction[].class).getBody();
    }

    public GoReaction GetReaction( final int goOriId ) {
        return mRestTemplate.getForObject( SERVER_URI + GET_REACTION_FROM_GENE,GoReaction.class, goOriId );
    }




}
