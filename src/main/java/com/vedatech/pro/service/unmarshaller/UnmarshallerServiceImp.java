package com.vedatech.pro.service.unmarshaller;

import com.vedatech.pro.model.invoice.jaxb.Comprobante;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

@Service
public class UnmarshallerServiceImp implements UnmarshallerService {
    @Override
    public <T> T contextFile(Class<T> tClass, String comprobante) throws JAXBException {

        try {
            StringReader com = new StringReader(comprobante);
            JAXBContext context = JAXBContext.newInstance(tClass);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Comprobante unmarshal = (Comprobante) unmarshaller.unmarshal(com);
       //     System.out.println("CFDI SERVICE IMPL EN UNMARSHALLER SERVICE " + unmarshal.getReceptor().getRfc() + unmarshal.getReceptor().getNombre());
            //   System.out.println("CFDI SERVICE IMPL ADDENDA " +unmarshal.getAddenda().getFacturaInterfactura());
            System.out.println("UNMARSHALLER " + unmarshal);
            return (T) unmarshal;
        } catch (JAXBException e) {
//            throw new RuntimeException("Could not unmarshall workflow xml",e);
            return null;
        }
    }
}
