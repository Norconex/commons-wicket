/* Copyright 2012-2014 Norconex Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.norconex.commons.wicket.markup.html.form;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.IFormSubmitter;
import org.apache.wicket.markup.html.form.validation.IFormValidator;
import org.apache.wicket.model.IModel;

/**
 * <p>
 * A form which can be used as a nested form without having its
 * form validation invoked when the parent form is submitted.  Can also be
 * used as a top level form.
 * </p>
 * <p>
 * It is a work around to the issue of inner forms being
 * validated even if when told otherwise when implementing
 * IFormVisitorParticipant to change this.  This class achieves this by storing
 * form validators separately from what the {@link Form}
 * does when the {@link #add(IFormValidator)} method is invoked.
 * The flow of the {@link #process(IFormSubmitter)} method has been changed
 * to invoke the {@link #validateIsolated()} instead of {@link #validate()}.
 * That way only when this form is submitted that the flow is triggered.
 * Otherwise, when submitted by a parent form, the standard {@link #validate()}
 * method is called, which does nothing.
 * </p>
 * <p>
 * See this ticket <a href="https://issues.apache.org/jira/browse/WICKET-3899">
 * https://issues.apache.org/jira/browse/WICKET-3899</a> for the issue
 * this class attempts to work around.
 * </p>
 * @author Pascal Essiembre
 * @param <T> The model object type
 */
public class IsolatedForm<T> extends Form<T> {


    //XXX This class is a hack to get around the issue of inner forms being
    //XXX validated even if when told otherwise when implementing
    //XXX IFormVisitorParticipant.  What we do instead is assign
    //XXX form validation to a fake form component.
    //XXX see: https://issues.apache.org/jira/browse/WICKET-3899
    //XXX see: http://apache-wicket.1842946.n4.nabble.com/Skip-validation-on-nested-form-s-form-level-validators-td3658350.html
    //XXX see: http://apache-wicket.1842946.n4.nabble.com/Nested-Forms-td1892335.html
    //XXX see: https://cwiki.apache.org/WICKET/nested-forms.html
    //XXX see: http://sanityresort.blogspot.ca/2011/07/validating-nested-forms-in-wicket.html
    //XXX see: https://cwiki.apache.org/WICKET/conditional-validation.html

    private static final long serialVersionUID = 7806818603026156064L;

    private final List<IFormValidator> formValidators =
            new ArrayList<IFormValidator>();

    /**
     * Constructor.
     * @param id wicket id
     */
    public IsolatedForm(String id) {
        this(id, null);
    }
    /**
     * Constructor.
     * @param id wicket id
     * @param model model
     */
    public IsolatedForm(String id, IModel<T> model) {
        super(id, model);
    }

    @Override
    public void add(IFormValidator validator) {
        formValidators.add(validator);
    }

    @Override
    public void process(IFormSubmitter submittingComponent) {
        //XXX copied from Form except for validateIsolated()
        //XXX make sure to check compatibility with each Wicket releases
        if (!isEnabledInHierarchy() || !isVisibleInHierarchy()) {
            return;
        }

        // run validation
        validateIsolated();

        // If a validation error occurred
        if (hasError()) {
            // mark all children as invalid
            markFormComponentsInvalid();

            // let subclass handle error
            callOnError(submittingComponent);
        } else {
            // mark all children as valid
            markFormComponentsValid();

            // before updating, call the interception method for clients
            beforeUpdateFormComponentModels();

            // Update model using form data
            updateFormComponentModels();

            // validate model objects after input values have been bound
            onValidateModelObjects();
            if (hasError()) {
                callOnError(submittingComponent);
                return;
            }

            // Form has no error
            delegateSubmit(submittingComponent);
        }
    }

    /**
     * Validates the form by checking required fields, converting raw input and running validators
     * for every form component, and last running global form validators. This method is typically
     * called before updating any models.
     * <p>
     * NOTE: in most cases, custom validations on the form can be achieved using an IFormValidator
     * that can be added using addValidator().
     * </p>
     */
    protected void validateIsolated() {
        if (isEnabledInHierarchy() && isVisibleInHierarchy()) {
            //XXX re-introduce those??
//                    validateComponents();
//                    validateFormValidators();
            for (IFormValidator validator : formValidators) {
                validateFormValidator(validator);
            }
            onValidate();
        }
    }


}
