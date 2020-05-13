package com.vedatech.pro.service.unmarshaller;

import javax.xml.bind.JAXBException;

public interface UnmarshallerService {

    public <T> T contextFile(Class<T> tClass, String comprobante) throws JAXBException;

}
