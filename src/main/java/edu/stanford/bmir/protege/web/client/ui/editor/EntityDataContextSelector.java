package edu.stanford.bmir.protege.web.client.ui.editor;

import com.google.inject.Inject;
import org.semanticweb.owlapi.model.EntityType;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 23/04/2013
 */
public class EntityDataContextSelector implements EditorManagerSelector {

    private Map<EntityType<?>, EditorManager<?, ?>> map = new HashMap<>();

    @Inject
    public EntityDataContextSelector(ClassFrameEditorManager classFrameEditorManager,
                                     ObjectPropertyFrameEditorManager objectPropertyFrameEditorManager,
                                     DataPropertyFrameEditorManager dataPropertyFrameEditorManager,
                                     AnnotationPropertyFrameEditorManager annotationPropertyFrameEditorManager,
                                     NamedIndividualFrameEditorManager namedIndividualFrameEditorManager) {
        map.put(EntityType.CLASS, classFrameEditorManager);
        map.put(EntityType.OBJECT_PROPERTY, objectPropertyFrameEditorManager);
        map.put(EntityType.DATA_PROPERTY, dataPropertyFrameEditorManager);
        map.put(EntityType.ANNOTATION_PROPERTY, annotationPropertyFrameEditorManager);
        map.put(EntityType.NAMED_INDIVIDUAL, namedIndividualFrameEditorManager);
    }

    @Override
    public boolean canEditContext(EditorCtx editorCtx) {
        if(!(editorCtx instanceof OWLEntityDataContext)) {
            return false;
        }
        EntityType<?> entityType = ((OWLEntityDataContext) editorCtx).getEntity().getEntityType();
        return map.containsKey(entityType);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <C extends EditorCtx, O extends Serializable> EditorManager<C, O> getEditorManager(EditorCtx editorContext) {
        EntityType entityType = ((OWLEntityDataContext) editorContext).getEntity().getEntityType();
        return (EditorManager<C, O>) map.get(entityType);
    }
}
