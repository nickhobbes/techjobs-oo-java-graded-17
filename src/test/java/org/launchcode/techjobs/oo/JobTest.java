package org.launchcode.techjobs.oo;

import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here

    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals(job1.getName(), "Product tester");
        assertEquals(job1.getEmployer().getValue(), "ACME");
        assertEquals(job1.getLocation().getValue(), "Desert");
        assertEquals(job1.getPositionType().getValue(), "Quality control");
        assertEquals(job1.getCoreCompetency().getValue(), "Persistence");

        assertTrue(job1.getName() instanceof String);
        assertTrue(job1.getEmployer() instanceof Employer);
        assertTrue(job1.getLocation() instanceof Location);
        assertTrue(job1.getPositionType() instanceof PositionType);
        assertTrue(job1.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job();
        Job job2 = new Job();

        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job1 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        assertEquals(job1.toString().charAt(0), '\n');
        assertEquals(job1.toString().charAt(job1.toString().length() - 1), '\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(job1.toString().contains("ID: " + job1.getId() + "\n"));
        assertTrue(job1.toString().contains("Name: " + job1.getName() + "\n"));
        assertTrue(job1.toString().contains("Employer: " + job1.getEmployer() + "\n"));
        assertTrue(job1.toString().contains("Location: " + job1.getLocation() + "\n"));
        assertTrue(job1.toString().contains("Position Type: " + job1.getPositionType() + "\n"));
        assertTrue(job1.toString().contains("Core Competency: " + job1.getCoreCompetency() + "\n"));
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job1 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));

        assertTrue(job1.toString().contains("Name: Data not available" + "\n"));
        assertTrue(job1.toString().contains("Employer: Data not available" + "\n"));
        assertTrue(job1.toString().contains("Location: Data not available" + "\n"));
        assertTrue(job1.toString().contains("Position Type: Data not available" + "\n"));
        assertTrue(job1.toString().contains("Core Competency: Data not available" + "\n"));
    }
}
