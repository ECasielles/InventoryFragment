package com.example.usuario.inventoryfragment.ui.dependency.interactor;

import com.example.usuario.inventoryfragment.data.db.model.Dependency;
import com.example.usuario.inventoryfragment.data.db.repository.DependencyRepository;

/**
 * Created by usuario on 27/11/17.
 */

public class AddEditDependencyInteractorImpl implements AddEditDependencyInteractor {

    //Aquí habría que controlarlo con excepciones en lugar de elseif
    @Override
    public void validateDependency(String name, String shortname, String description, OnAddEditFinishedListener listener) {
        if (name.isEmpty())
            listener.onNameEmptyError();
        else if (shortname.isEmpty())
            listener.onShortNameEmptyError();
        else if (shortname.length() < 2 && shortname.length() > 5)
            listener.onShortNameLengthError();
        else if (description.isEmpty())
            listener.onDescriptionEmptyError();
        else if (DependencyRepository.getInstance().exists(name, shortname))
            listener.onSuccess(name, shortname, description);
    }

    @Override
    public void addDependency(String name, String shortname, String description) {
        Dependency dependency = new Dependency(-1, name, shortname, description);
        DependencyRepository.getInstance().addDependency(dependency);
    }

    @Override
    public void editDependency(Dependency dependency, String description, OnAddEditFinishedListener listener) {
        if(!description.isEmpty()) {
            DependencyRepository.getInstance().editDependency(dependency, description);
            listener.onSuccess(dependency.getName(), dependency.getShortname(), dependency.getDescription());
        } else
            listener.onDescriptionEmptyError();
    }


}
