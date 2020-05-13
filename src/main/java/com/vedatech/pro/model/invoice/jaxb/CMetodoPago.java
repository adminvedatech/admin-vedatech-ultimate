package com.vedatech.pro.model.invoice.jaxb;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para c_MetodoPago.
 *
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="c_MetodoPago">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;whiteSpace value="collapse"/>
 *     &lt;enumeration value="PUE"/>
 *     &lt;enumeration value="PIP"/>
 *     &lt;enumeration value="PPD"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "c_MetodoPago", namespace = "http://www.sat.gob.mx/sitio_internet/cfd/catalogos")
@XmlEnum
public enum CMetodoPago {

    PUE,
    PIP,
    PPD;

    public String value() {
        return name();
    }

    public static CMetodoPago fromValue(String v) {
        return valueOf(v);
    }

}

