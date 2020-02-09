package com.shourya.demo.core.service.Impl;

import com.shourya.demo.helper.error.ApiException;
import com.shourya.demo.model.Movie.MovieModel;
import com.shourya.demo.persistance.repository.MovieRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MovieServiceImplTest {
    @Mock
    MovieRepository movieRepositoryMock;
    @InjectMocks
    MovieServiceImpl movieService;

    @Test
    public void testFindMovieData() throws ApiException {
        when(movieRepositoryMock.findByTitle("Hot Fuzz")).thenReturn(new MovieModel(
                "Hot Fuzz",
                "Edgar Wright,",
                "Nira Park,Tim Bevan,Eric Fellner,",
                "Simon Pegg,Nick Frost,Jim Broadbent,",
                "David Arnold,",
                "StudioCanal Working,Title Films,Big Talk,Productions ",
                "Fri Feb 16 00:00:00 IST 2007",
                "121 minutes[1],",
                "English ",
                "US$12–16 million[3][4],",
                "$80.7 million[5],",
                "Hot Fuzz is a 2007 action comedy film directed by Edgar Wright, written by Wright and Simon Pegg, and starring Pegg and Nick Frost. Pegg and Frost play police officers attempting to solve a series of mysterious deaths in Sandford, a village in the West Country. Wright, Pegg, Frost and producer Nira Park had previously worked together on the television series Spaced and the 2004 film Shaun of the Dead.[6]"
        ){
        });
        assertEquals(MovieModel.builder()
                .title("Hot Fuzz")
                .director("Edgar Wright,")
                .producer("Nira Park,Tim Bevan,Eric Fellner,")
                .actors("Simon Pegg,Nick Frost,Jim Broadbent,")
                .musicComposer("David Arnold,")
                .productionHouse("StudioCanal Working,Title Films,Big Talk,Productions ")
                .releaseDate("Fri Feb 16 00:00:00 IST 2007")
                .duration("121 minutes[1],")
                .budget("US$12–16 million[3][4],")
                .boxOfficeCollection("$80.7 million[5],")
                .language("English ")
                .description("Hot Fuzz is a 2007 action comedy film directed by Edgar Wright, written by Wright and Simon Pegg, and starring Pegg and Nick Frost. Pegg and Frost play police officers attempting to solve a series of mysterious deaths in Sandford, a village in the West Country. Wright, Pegg, Frost and producer Nira Park had previously worked together on the television series Spaced and the 2004 film Shaun of the Dead.[6]")
                .build(), movieService.getData("Hot Fuzz"));
    }

}
