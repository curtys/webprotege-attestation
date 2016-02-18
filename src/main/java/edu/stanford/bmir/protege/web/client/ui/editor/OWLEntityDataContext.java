package edu.stanford.bmir.protege.web.client.ui.editor;

import edu.stanford.bmir.protege.web.shared.project.ProjectId;
import org.semanticweb.owlapi.model.OWLEntity;

import static com.google.common.base.MoreObjects.toStringHelper;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 23/04/2013
 */
public class OWLEntityDataContext extends EditorCtx {

    private OWLEntity entity;

    public OWLEntityDataContext(ProjectId projectId, OWLEntity entity) {
        super(projectId);
        this.entity = entity;
    }

    public OWLEntity getEntity() {
        return entity;
    }


    @Override
    public String toString() {
        return toStringHelper("OWLEntityDataContext")
                .addValue(entity)
                .toString();
    }
}
