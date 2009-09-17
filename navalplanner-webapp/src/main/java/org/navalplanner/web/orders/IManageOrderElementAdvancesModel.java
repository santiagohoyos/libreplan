package org.navalplanner.web.orders;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.navalplanner.business.advance.entities.AdvanceAssigment;
import org.navalplanner.business.advance.entities.AdvanceMeasurement;
import org.navalplanner.business.advance.entities.AdvanceType;
import org.navalplanner.business.advance.exceptions.DuplicateAdvanceAssigmentForOrderElementException;
import org.navalplanner.business.advance.exceptions.DuplicateValueTrueReportGlobalAdvanceException;
import org.navalplanner.business.common.exceptions.InstanceNotFoundException;
import org.navalplanner.business.orders.entities.OrderElement;

/**
 * @author Susana Montes Pedreira <smontes@wirelessgalicia.com>
 */
public interface IManageOrderElementAdvancesModel {

    public void prepareEditAdvanceMeasurements(AdvanceAssigment advanceAssigment);

    public List<AdvanceMeasurement> getAdvanceMeasurements();

    public List<AdvanceAssigment> getAdvanceAssigments();

    public void init(OrderElement orderElement);

    public void addNewLineAdvaceAssigment();

    public void addNewLineAdvaceMeasurement();

    public void removeLineAdvanceAssigment(AdvanceAssigment advance);

    public void removeLineAdvanceMeasurement(AdvanceMeasurement advance);

    public List<AdvanceType> getActivesAdvanceTypes();

    public boolean isReadOnlyAdvanceMeasurements();

    public void cleanAdvance();

    public boolean isPrecisionValid(BigDecimal value);

    public boolean greatThanMaxValue(BigDecimal value);

    public boolean isDistinctValidDate(Date value,
            AdvanceMeasurement newAdvanceMeasurement);

    public BigDecimal getUnitPrecision();

    public AdvanceMeasurement getFirstAdvanceMeasurement(
            AdvanceAssigment advanceAssigment);

    public void sortListAdvanceMeasurement();

    public String getInfoAdvanceAssigment();

    public void accept()throws InstanceNotFoundException,
            DuplicateAdvanceAssigmentForOrderElementException,
            DuplicateValueTrueReportGlobalAdvanceException;

    public BigDecimal getPercentageAdvanceMeasurement(
            AdvanceMeasurement advanceMeasurement);

}
