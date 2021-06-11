package com.desafio.periodosperdidos.service;

import com.desafio.periodosperdidos.model.GDD;
import com.desafio.periodosperdidos.model.ParseGDD;
import com.desafio.periodosperdidos.swagger.controller.IUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;

@Service
public class FaltantesService implements IUtil {

    /**
     * method: getPeriodos
     * @return ParseGDD
     * @throws IOException
     */
    public ParseGDD getPeriodos () throws IOException {

        ParseGDD parseGDD = null;

        URL url = null;
        try {
            url = new URL("http://127.0.0.1:8080/periodos/api");
        } catch (MalformedURLException e) {
            log.error("Malformed URL", e);
            throw e;
        }

        // Open a connection on the URL and cast the response
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            log.error("Connection refused to 'http://127.0.0.1:8080/periodos/api'", e);
            throw e;
        }

        // Set the request method
        connection.setRequestProperty("accept", "application/json");

        // This line makes the request
        InputStream responseStream = null;
        try {
            responseStream = connection.getInputStream();
        } catch (IOException e) {
            log.error("Data transmission failure", e);
            throw e;
        }

        try {
            // Manually converting the InputStream to parseGDD using Jackson
            ObjectMapper mapper = new ObjectMapper();
            parseGDD = mapper.readValue(responseStream, ParseGDD.class);
        }
        catch (Exception e) {
            log.error("Error parsing data structure received from 'http://localhost:8080/periodos/api' service", e);
            throw e;
        }

        return parseGDD;
    }

    /**
     * method: searchsMissingDates
     * @param parseGDD
     * @return
     */
    public GDD searchsMissingDates (ParseGDD parseGDD) {

        GDD gdd = new GDD();
        gdd.setId( parseGDD.getId() );
        gdd.setFechaCreacion( LocalDate.parse(parseGDD.getFechaCreacion()) );
        gdd.setFechaFin( LocalDate.parse(parseGDD.getFechaFin()) );

        //Generates the dates contained between the Start and End date range.
        for (LocalDate date = gdd.getFechaCreacion(); date.isBefore(gdd.getFechaFin().plusDays(1)); date = date.plusMonths(1)) {

            //Validates which of those dates are missing from the list
            if (!parseGDD.getFechas().contains(date.toString()))
                gdd.addFechaFaltante(date);
            else
                gdd.addFecha(date);
        }

        return gdd;
    }
}
