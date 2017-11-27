package com.example.usuario.inventoryfragment.ui.dependency;

import com.example.usuario.inventoryfragment.data.db.model.Dependency;
import com.example.usuario.inventoryfragment.data.db.repository.DependencyRepository;
import com.example.usuario.inventoryfragment.ui.dependency.contract.AddEditDependencyContract;

/**
 * Created by usuario on 24/11/17.
 */

public class AddEditDependencyInteractor implements AddEditDependencyContract.Interactor {

    //Aquí habría que controlarlo con excepciones en lugar de elseif
    @Override
    public void validateDependecy(String name, String shortname, String description, OnAddeditFinishedListener listener) {
        if (name.isEmpty())
            listener.onNameEmptyError();
        else if (shortname.isEmpty())
            listener.onShortNameEmptyError();
        else if (shortname.length() < 2 && shortname.length() > 5)
            listener.onShortNameLengthError();
        else if (description.isEmpty())
            listener.onDescriptionEmptyError();
        else if (DependencyRepository.getInstance().validateDependency(name, shortname))
            listener.onSuccess(name, shortname, description);
    }

    @Override
    public void addDependency(String name, String sortname, String description) {
        Dependency dependency = new Dependency(20, name, sortname, description);
        DependencyRepository.getInstance().addDependency(dependency);
    }
}
