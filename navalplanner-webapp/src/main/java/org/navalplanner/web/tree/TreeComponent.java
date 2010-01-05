/*
 * This file is part of ###PROJECT_NAME###
 *
 * Copyright (C) 2009 Fundación para o Fomento da Calidade Industrial e
 *                    Desenvolvemento Tecnolóxico de Galicia
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.navalplanner.web.tree;

import static org.navalplanner.web.I18nHelper._;

import java.util.List;

import org.navalplanner.web.orders.OrderElementTreeController;
import org.zkoss.zk.ui.HtmlMacroComponent;
import org.zkoss.zk.ui.util.Composer;

/**
 * macro component for order elements tree and similar pages<br />
 * @author Óscar González Fernández <ogonzalez@igalia.com>
 */
public abstract class TreeComponent extends HtmlMacroComponent {

    private static final String CONTROLLER_NAME = "treeController";

    public static class Column {
        private String label;

        private String cssClass;

        private String tooltip;

        public Column(String label, String cssClass){
            this(label, cssClass, null);
        }

        public Column(String label, String cssClass, String tooltip) {
            this.label = label;
            this.cssClass = cssClass;
            this.tooltip = tooltip;
        }

        public String getLabel() {
            return label;
        }

        public String getCssClass() {
            return cssClass;
        }

        public String getTooltip() {
            return tooltip;
        }
    }

    protected final Column codeColumn = new Column(_("Code"), "code");
    protected final Column nameAndDescriptionColumn = new Column(
            _("Name and description"), "name");
    protected final Column operationsColumn = new Column(_("Operations"),
            "operations");

    public abstract List<Column> getColumns();

    public void clear() {
        OrderElementTreeController controller = (OrderElementTreeController) getVariable(
                CONTROLLER_NAME, true);
        controller.clear();
    }

    public void useController(TreeController<?> controller) {
        doAfterComposeOnController(controller);
        this.setVariable(CONTROLLER_NAME, controller, true);
    }

    private void doAfterComposeOnController(Composer controller) {
        try {
            controller.doAfterCompose(this);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getAddElementLabel() {
        return _("New order element");
    }

    public boolean isCreateTemplateEnabled() {
        return true;
    }

    public String getRemoveElementLabel() {
        return _("Delete order element");
    }

}
