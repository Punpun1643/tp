package seedu.address.model.group;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_GROUP_NAME_NUS_DATA_SCIENCE_SOCIETY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_GROUP_NAME_NUS_FINTECH_SOCIETY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.testutil.TypicalGroups.NUS_DATA_SCIENCE_SOCIETY;
import static seedu.address.testutil.TypicalGroups.NUS_FINTECH_SOCIETY;
import static seedu.address.testutil.TypicalPersons.BOB;

import org.junit.jupiter.api.Test;

import seedu.address.model.person.Person;
import seedu.address.testutil.GroupBuilder;
import seedu.address.testutil.PersonBuilder;

public class GroupTest {
    @Test
    public void isSameGroup() {
        // same object -> returns true
        assertTrue(NUS_FINTECH_SOCIETY.isSameGroup(NUS_FINTECH_SOCIETY));

        // null -> returns false
        assertFalse(NUS_FINTECH_SOCIETY.isSameGroup(null));

        // same name -> returns true
        Group editedNusFintechSociety = new GroupBuilder(NUS_FINTECH_SOCIETY).build();
        assertTrue(NUS_FINTECH_SOCIETY.isSameGroup(editedNusFintechSociety));

        // different name -> returns false
        editedNusFintechSociety = new GroupBuilder(NUS_FINTECH_SOCIETY)
                .withGroupName(VALID_GROUP_NAME_NUS_DATA_SCIENCE_SOCIETY).build();
        assertFalse(NUS_FINTECH_SOCIETY.isSameGroup(editedNusFintechSociety));

        // name has trailing spaces, all other attributes same -> returns false
        String nameWithTrailingSpaces = VALID_GROUP_NAME_NUS_FINTECH_SOCIETY + " ";
        editedNusFintechSociety = new GroupBuilder(NUS_FINTECH_SOCIETY).withGroupName(nameWithTrailingSpaces).build();
        assertFalse(NUS_FINTECH_SOCIETY.isSameGroup(editedNusFintechSociety));
    }

    @Test
    public void equals() {
        // same values -> returns true
        Group nusFintechSocietyCopy = new GroupBuilder(NUS_FINTECH_SOCIETY).build();
        assertTrue(NUS_FINTECH_SOCIETY.equals(nusFintechSocietyCopy));

        // same object -> returns true
        assertTrue(NUS_FINTECH_SOCIETY.equals(NUS_FINTECH_SOCIETY));

        // null -> returns false
        assertFalse(NUS_FINTECH_SOCIETY.equals(null));

        // different type -> returns false
        assertFalse(NUS_FINTECH_SOCIETY.equals(5));

        // different group -> returns false
        assertFalse(NUS_FINTECH_SOCIETY.equals(NUS_DATA_SCIENCE_SOCIETY));

        // different groupName -> returns false
        Group editedNusFintechSociety = new GroupBuilder(NUS_FINTECH_SOCIETY)
                .withGroupName(VALID_GROUP_NAME_NUS_DATA_SCIENCE_SOCIETY).build();
        assertFalse(NUS_FINTECH_SOCIETY.equals(editedNusFintechSociety));

        // group name differs in case, all other attributes same -> returns true
        Group editedNusFintechSocietyLowerCase = new GroupBuilder(NUS_FINTECH_SOCIETY)
                .withGroupName(VALID_GROUP_NAME_NUS_FINTECH_SOCIETY.toLowerCase()).build();
        assertTrue(NUS_FINTECH_SOCIETY.isSameGroup(editedNusFintechSocietyLowerCase));
    }
}
