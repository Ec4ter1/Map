package factory;

import model.Container;

public interface Factory {
    Container createContainer(ContainerStrategy startegy);
}