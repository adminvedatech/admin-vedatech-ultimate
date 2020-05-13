package com.vedatech.pro.model.invoice.jaxb;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Clase Java para anonymous complex type.
 *
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CfdiRelacionados" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="CfdiRelacionado" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;attribute name="UUID" use="required">
 *                             &lt;simpleType>
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                 &lt;length value="36"/>
 *                                 &lt;whiteSpace value="collapse"/>
 *                                 &lt;pattern value="[a-f0-9A-F]{8}-[a-f0-9A-F]{4}-[a-f0-9A-F]{4}-[a-f0-9A-F]{4}-[a-f0-9A-F]{12}"/>
 *                               &lt;/restriction>
 *                             &lt;/simpleType>
 *                           &lt;/attribute>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="TipoRelacion" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_TipoRelacion" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Emisor">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="Rfc" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_RFC" />
 *                 &lt;attribute name="Nombre">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;minLength value="1"/>
 *                       &lt;maxLength value="254"/>
 *                       &lt;whiteSpace value="collapse"/>
 *                       &lt;pattern value="[^|]{1,254}"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *                 &lt;attribute name="RegimenFiscal" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_RegimenFiscal" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Receptor">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="Rfc" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_RFC" />
 *                 &lt;attribute name="Nombre">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;minLength value="1"/>
 *                       &lt;maxLength value="254"/>
 *                       &lt;whiteSpace value="collapse"/>
 *                       &lt;pattern value="[^|]{1,254}"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *                 &lt;attribute name="ResidenciaFiscal" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Pais" />
 *                 &lt;attribute name="NumRegIdTrib">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;minLength value="1"/>
 *                       &lt;maxLength value="40"/>
 *                       &lt;whiteSpace value="collapse"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *                 &lt;attribute name="UsoCFDI" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_UsoCFDI" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Conceptos">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Concepto" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Impuestos" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="Traslados" minOccurs="0">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="Traslado" maxOccurs="unbounded">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;attribute name="Base" use="required">
 *                                                           &lt;simpleType>
 *                                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *                                                               &lt;fractionDigits value="6"/>
 *                                                               &lt;minInclusive value="0.000001"/>
 *                                                               &lt;whiteSpace value="collapse"/>
 *                                                             &lt;/restriction>
 *                                                           &lt;/simpleType>
 *                                                         &lt;/attribute>
 *                                                         &lt;attribute name="Impuesto" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Impuesto" />
 *                                                         &lt;attribute name="TipoFactor" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_TipoFactor" />
 *                                                         &lt;attribute name="TasaOCuota">
 *                                                           &lt;simpleType>
 *                                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *                                                               &lt;fractionDigits value="6"/>
 *                                                               &lt;minInclusive value="0.000000"/>
 *                                                               &lt;whiteSpace value="collapse"/>
 *                                                             &lt;/restriction>
 *                                                           &lt;/simpleType>
 *                                                         &lt;/attribute>
 *                                                         &lt;attribute name="Importe" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="Retenciones" minOccurs="0">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="Retencion" maxOccurs="unbounded">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;attribute name="Base" use="required">
 *                                                           &lt;simpleType>
 *                                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *                                                               &lt;fractionDigits value="6"/>
 *                                                               &lt;minInclusive value="0.000001"/>
 *                                                               &lt;whiteSpace value="collapse"/>
 *                                                             &lt;/restriction>
 *                                                           &lt;/simpleType>
 *                                                         &lt;/attribute>
 *                                                         &lt;attribute name="Impuesto" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Impuesto" />
 *                                                         &lt;attribute name="TipoFactor" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_TipoFactor" />
 *                                                         &lt;attribute name="TasaOCuota" use="required">
 *                                                           &lt;simpleType>
 *                                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *                                                               &lt;whiteSpace value="collapse"/>
 *                                                               &lt;minInclusive value="0.000000"/>
 *                                                               &lt;fractionDigits value="6"/>
 *                                                             &lt;/restriction>
 *                                                           &lt;/simpleType>
 *                                                         &lt;/attribute>
 *                                                         &lt;attribute name="Importe" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="InformacionAduanera" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;attribute name="NumeroPedimento" use="required">
 *                                       &lt;simpleType>
 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                           &lt;length value="21"/>
 *                                           &lt;pattern value="[0-9]{2}  [0-9]{2}  [0-9]{4}  [0-9]{7}"/>
 *                                         &lt;/restriction>
 *                                       &lt;/simpleType>
 *                                     &lt;/attribute>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="CuentaPredial" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;attribute name="Numero" use="required">
 *                                       &lt;simpleType>
 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                           &lt;minLength value="1"/>
 *                                           &lt;maxLength value="150"/>
 *                                           &lt;whiteSpace value="collapse"/>
 *                                           &lt;pattern value="[0-9]{1,150}"/>
 *                                         &lt;/restriction>
 *                                       &lt;/simpleType>
 *                                     &lt;/attribute>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="ComplementoConcepto" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;any maxOccurs="unbounded"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="Parte" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="InformacionAduanera" maxOccurs="unbounded" minOccurs="0">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;attribute name="NumeroPedimento" use="required">
 *                                                 &lt;simpleType>
 *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                                     &lt;length value="21"/>
 *                                                     &lt;pattern value="[0-9]{2}  [0-9]{2}  [0-9]{4}  [0-9]{7}"/>
 *                                                   &lt;/restriction>
 *                                                 &lt;/simpleType>
 *                                               &lt;/attribute>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                     &lt;attribute name="ClaveProdServ" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_ClaveProdServ" />
 *                                     &lt;attribute name="NoIdentificacion">
 *                                       &lt;simpleType>
 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                           &lt;minLength value="1"/>
 *                                           &lt;maxLength value="100"/>
 *                                           &lt;whiteSpace value="collapse"/>
 *                                           &lt;pattern value="[^|]{1,100}"/>
 *                                         &lt;/restriction>
 *                                       &lt;/simpleType>
 *                                     &lt;/attribute>
 *                                     &lt;attribute name="Cantidad" use="required">
 *                                       &lt;simpleType>
 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *                                           &lt;fractionDigits value="6"/>
 *                                           &lt;minInclusive value="0.000001"/>
 *                                           &lt;whiteSpace value="collapse"/>
 *                                         &lt;/restriction>
 *                                       &lt;/simpleType>
 *                                     &lt;/attribute>
 *                                     &lt;attribute name="Unidad">
 *                                       &lt;simpleType>
 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                           &lt;minLength value="1"/>
 *                                           &lt;maxLength value="20"/>
 *                                           &lt;whiteSpace value="collapse"/>
 *                                           &lt;pattern value="[^|]{1,20}"/>
 *                                         &lt;/restriction>
 *                                       &lt;/simpleType>
 *                                     &lt;/attribute>
 *                                     &lt;attribute name="Descripcion" use="required">
 *                                       &lt;simpleType>
 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                           &lt;minLength value="1"/>
 *                                           &lt;maxLength value="1000"/>
 *                                           &lt;whiteSpace value="collapse"/>
 *                                           &lt;pattern value="[^|]{1,1000}"/>
 *                                         &lt;/restriction>
 *                                       &lt;/simpleType>
 *                                     &lt;/attribute>
 *                                     &lt;attribute name="ValorUnitario" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
 *                                     &lt;attribute name="Importe" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                           &lt;attribute name="ClaveProdServ" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_ClaveProdServ" />
 *                           &lt;attribute name="NoIdentificacion">
 *                             &lt;simpleType>
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                 &lt;whiteSpace value="collapse"/>
 *                                 &lt;minLength value="1"/>
 *                                 &lt;maxLength value="100"/>
 *                                 &lt;pattern value="[^|]{1,100}"/>
 *                               &lt;/restriction>
 *                             &lt;/simpleType>
 *                           &lt;/attribute>
 *                           &lt;attribute name="Cantidad" use="required">
 *                             &lt;simpleType>
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *                                 &lt;fractionDigits value="6"/>
 *                                 &lt;minInclusive value="0.000001"/>
 *                                 &lt;whiteSpace value="collapse"/>
 *                               &lt;/restriction>
 *                             &lt;/simpleType>
 *                           &lt;/attribute>
 *                           &lt;attribute name="ClaveUnidad" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_ClaveUnidad" />
 *                           &lt;attribute name="Unidad">
 *                             &lt;simpleType>
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                 &lt;minLength value="1"/>
 *                                 &lt;maxLength value="20"/>
 *                                 &lt;whiteSpace value="collapse"/>
 *                                 &lt;pattern value="[^|]{1,20}"/>
 *                               &lt;/restriction>
 *                             &lt;/simpleType>
 *                           &lt;/attribute>
 *                           &lt;attribute name="Descripcion" use="required">
 *                             &lt;simpleType>
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                 &lt;minLength value="1"/>
 *                                 &lt;maxLength value="1000"/>
 *                                 &lt;whiteSpace value="collapse"/>
 *                                 &lt;pattern value="[^|]{1,1000}"/>
 *                               &lt;/restriction>
 *                             &lt;/simpleType>
 *                           &lt;/attribute>
 *                           &lt;attribute name="ValorUnitario" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
 *                           &lt;attribute name="Importe" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
 *                           &lt;attribute name="Descuento" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Impuestos" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Retenciones" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Retencion" maxOccurs="unbounded">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;attribute name="Impuesto" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Impuesto" />
 *                                     &lt;attribute name="Importe" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Traslados" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Traslado" maxOccurs="unbounded">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;attribute name="Impuesto" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Impuesto" />
 *                                     &lt;attribute name="TipoFactor" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_TipoFactor" />
 *                                     &lt;attribute name="TasaOCuota" use="required">
 *                                       &lt;simpleType>
 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *                                           &lt;whiteSpace value="collapse"/>
 *                                           &lt;minInclusive value="0.000000"/>
 *                                           &lt;fractionDigits value="6"/>
 *                                         &lt;/restriction>
 *                                       &lt;/simpleType>
 *                                     &lt;/attribute>
 *                                     &lt;attribute name="Importe" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="TotalImpuestosRetenidos" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
 *                 &lt;attribute name="TotalImpuestosTrasladados" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Complemento" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;any maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Addenda" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;any maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="Version" use="required" fixed="3.3">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;whiteSpace value="collapse"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="Serie">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;minLength value="1"/>
 *             &lt;maxLength value="25"/>
 *             &lt;whiteSpace value="collapse"/>
 *             &lt;pattern value="[^|]{1,25}"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="Folio">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;minLength value="1"/>
 *             &lt;maxLength value="40"/>
 *             &lt;whiteSpace value="collapse"/>
 *             &lt;pattern value="[^|]{1,40}"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="Fecha" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_FechaH" />
 *       &lt;attribute name="Sello" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;whiteSpace value="collapse"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="FormaPago" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_FormaPago" />
 *       &lt;attribute name="NoCertificado" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;length value="20"/>
 *             &lt;whiteSpace value="collapse"/>
 *             &lt;pattern value="[0-9]{20}"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="Certificado" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;whiteSpace value="collapse"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="CondicionesDePago">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;whiteSpace value="collapse"/>
 *             &lt;minLength value="1"/>
 *             &lt;maxLength value="1000"/>
 *             &lt;pattern value="[^|]{1,1000}"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="SubTotal" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
 *       &lt;attribute name="Descuento" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
 *       &lt;attribute name="Moneda" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Moneda" />
 *       &lt;attribute name="TipoCambio">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *             &lt;fractionDigits value="6"/>
 *             &lt;minInclusive value="0.000001"/>
 *             &lt;whiteSpace value="collapse"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="Total" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
 *       &lt;attribute name="TipoDeComprobante" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_TipoDeComprobante" />
 *       &lt;attribute name="MetodoPago" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_MetodoPago" />
 *       &lt;attribute name="LugarExpedicion" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_CodigoPostal" />
 *       &lt;attribute name="Confirmacion">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;whiteSpace value="collapse"/>
 *             &lt;length value="5"/>
 *             &lt;pattern value="[0-9a-zA-Z]{5}"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "cfdiRelacionados",
        "emisor",
        "receptor",
        "conceptos",
        "impuestos",
        "complemento",
        "addenda"
})
@XmlRootElement(name = "Comprobante", namespace = "http://www.sat.gob.mx/cfd/3")
public class Comprobante {

    @XmlElement(name = "CfdiRelacionados", namespace = "http://www.sat.gob.mx/cfd/3")
    protected Comprobante.CfdiRelacionados cfdiRelacionados;
    @XmlElement(name = "Emisor", namespace = "http://www.sat.gob.mx/cfd/3", required = true)
    protected Comprobante.Emisor emisor;
    @XmlElement(name = "Receptor", namespace = "http://www.sat.gob.mx/cfd/3", required = true)
    protected Comprobante.Receptor receptor;
    @XmlElement(name = "Conceptos", namespace = "http://www.sat.gob.mx/cfd/3", required = true)
    protected Comprobante.Conceptos conceptos;
    @XmlElement(name = "Impuestos", namespace = "http://www.sat.gob.mx/cfd/3")
    protected Comprobante.Impuestos impuestos;
    @XmlElement(name = "Complemento", namespace = "http://www.sat.gob.mx/cfd/3")
    protected List<Complemento> complemento;
    @XmlElement(name = "Addenda", namespace = "http://www.sat.gob.mx/cfd/3")
    protected Comprobante.Addenda addenda;
    //    @XmlElement(name = "FacturaInterfactura", namespace = "http://www.sat.gob.mx/cfd/3")
//    protected Comprobante.Addenda.FacturaInterfactura facturaInterfactura;
    @XmlAttribute(name = "Version", required = true)
    protected String version;
    @XmlAttribute(name = "Serie")
    protected String serie;
    @XmlAttribute(name = "Folio")
    protected String folio;
    @XmlAttribute(name = "Fecha", required = true)
    protected XMLGregorianCalendar fecha;
    @XmlAttribute(name = "Sello", required = true)
    protected String sello;
    @XmlAttribute(name = "FormaPago")
    protected String formaPago;
    @XmlAttribute(name = "NoCertificado", required = true)
    protected String noCertificado;
    @XmlAttribute(name = "Certificado", required = true)
    protected String certificado;
    @XmlAttribute(name = "CondicionesDePago")
    protected String condicionesDePago;
    @XmlAttribute(name = "SubTotal", required = true)
    protected BigDecimal subTotal;
    @XmlAttribute(name = "Descuento")
    protected BigDecimal descuento;
    @XmlAttribute(name = "Moneda", required = true)
    protected CMoneda moneda;
    @XmlAttribute(name = "TipoCambio")
    protected BigDecimal tipoCambio;
    @XmlAttribute(name = "Total", required = true)
    protected BigDecimal total;
    @XmlAttribute(name = "TipoDeComprobante", required = true)
    protected CTipoDeComprobante tipoDeComprobante;
    @XmlAttribute(name = "MetodoPago")
    protected CMetodoPago metodoPago;
    @XmlAttribute(name = "LugarExpedicion", required = true)
    protected String lugarExpedicion;
    @XmlAttribute(name = "Confirmacion")
    protected String confirmacion;

    /**
     * Obtiene el valor de la propiedad cfdiRelacionados.
     *
     * @return
     *     possible object is
     *     {@link Comprobante.CfdiRelacionados }
     *
     */
    public Comprobante.CfdiRelacionados getCfdiRelacionados() {
        return cfdiRelacionados;
    }

    /**
     * Define el valor de la propiedad cfdiRelacionados.
     *
     * @param value
     *     allowed object is
     *     {@link Comprobante.CfdiRelacionados }
     *
     */
    public void setCfdiRelacionados(Comprobante.CfdiRelacionados value) {
        this.cfdiRelacionados = value;
    }

    /**
     * Obtiene el valor de la propiedad emisor.
     *
     * @return
     *     possible object is
     *     {@link Comprobante.Emisor }
     *
     */
    public Comprobante.Emisor getEmisor() {
        return emisor;
    }

    /**
     * Define el valor de la propiedad emisor.
     *
     * @param value
     *     allowed object is
     *     {@link Comprobante.Emisor }
     *
     */
    public void setEmisor(Comprobante.Emisor value) {
        this.emisor = value;
    }

    /**
     * Obtiene el valor de la propiedad receptor.
     *
     * @return
     *     possible object is
     *     {@link Comprobante.Receptor }
     *
     */
    public Comprobante.Receptor getReceptor() {
        return receptor;
    }

    /**
     * Define el valor de la propiedad receptor.
     *
     * @param value
     *     allowed object is
     *     {@link Comprobante.Receptor }
     *
     */
    public void setReceptor(Comprobante.Receptor value) {
        this.receptor = value;
    }

    /**
     * Obtiene el valor de la propiedad conceptos.
     *
     * @return
     *     possible object is
     *     {@link Comprobante.Conceptos }
     *
     */
    public Comprobante.Conceptos getConceptos() {
        return conceptos;
    }

    /**
     * Define el valor de la propiedad conceptos.
     *
     * @param value
     *     allowed object is
     *     {@link Comprobante.Conceptos }
     *
     */
    public void setConceptos(Comprobante.Conceptos value) {
        this.conceptos = value;
    }

    /**
     * Obtiene el valor de la propiedad impuestos.
     *
     * @return
     *     possible object is
     *     {@link Comprobante.Impuestos }
     *
     */
    public Comprobante.Impuestos getImpuestos() {
        return impuestos;
    }

    /**
     * Define el valor de la propiedad impuestos.
     *
     * @param value
     *     allowed object is
     *     {@link Comprobante.Impuestos }
     *
     */
    public void setImpuestos(Comprobante.Impuestos value) {
        this.impuestos = value;
    }

    /**
     * Gets the value of the complemento property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the complemento property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getComplemento().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Comprobante.Complemento }
     *
     *
     */
    public List<Complemento> getComplemento() {
        if (complemento == null) {
            complemento = new ArrayList<Complemento>();
        }
        return this.complemento;
    }

    /**
     * Obtiene el valor de la propiedad addenda.
     *
     * @return
     *     possible object is
     *     {@link Comprobante.Addenda }
     *
     */
    public Comprobante.Addenda getAddenda() {
        return addenda;
    }

    /**
     * Define el valor de la propiedad addenda.
     *
     * @param value
     *     allowed object is
     *     {@link Comprobante.Addenda }
     *
     */
    public void setAddenda(Comprobante.Addenda value) {
        this.addenda = value;
    }

    /**
     * Obtiene el valor de la propiedad version.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getVersion() {
        if (version == null) {
            return "3.3";
        } else {
            return version;
        }
    }

    /**
     * Define el valor de la propiedad version.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Obtiene el valor de la propiedad serie.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSerie() {
        return serie;
    }

    /**
     * Define el valor de la propiedad serie.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSerie(String value) {
        this.serie = value;
    }

    /**
     * Obtiene el valor de la propiedad folio.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFolio() {
        return folio;
    }

    /**
     * Define el valor de la propiedad folio.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFolio(String value) {
        this.folio = value;
    }

    /**
     * Obtiene el valor de la propiedad fecha.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getFecha() {
        return fecha;
    }

    /**
     * Define el valor de la propiedad fecha.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setFecha(XMLGregorianCalendar value) {
        this.fecha = value;
    }

    /**
     * Obtiene el valor de la propiedad sello.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSello() {
        return sello;
    }

    /**
     * Define el valor de la propiedad sello.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSello(String value) {
        this.sello = value;
    }

    /**
     * Obtiene el valor de la propiedad formaPago.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFormaPago() {
        return formaPago;
    }

    /**
     * Define el valor de la propiedad formaPago.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFormaPago(String value) {
        this.formaPago = value;
    }

    /**
     * Obtiene el valor de la propiedad noCertificado.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNoCertificado() {
        return noCertificado;
    }

    /**
     * Define el valor de la propiedad noCertificado.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNoCertificado(String value) {
        this.noCertificado = value;
    }

    /**
     * Obtiene el valor de la propiedad certificado.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCertificado() {
        return certificado;
    }

    /**
     * Define el valor de la propiedad certificado.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCertificado(String value) {
        this.certificado = value;
    }

    /**
     * Obtiene el valor de la propiedad condicionesDePago.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCondicionesDePago() {
        return condicionesDePago;
    }

    /**
     * Define el valor de la propiedad condicionesDePago.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCondicionesDePago(String value) {
        this.condicionesDePago = value;
    }

    /**
     * Obtiene el valor de la propiedad subTotal.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getSubTotal() {
        return subTotal;
    }

    /**
     * Define el valor de la propiedad subTotal.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setSubTotal(BigDecimal value) {
        this.subTotal = value;
    }

    /**
     * Obtiene el valor de la propiedad descuento.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getDescuento() {
        return descuento;
    }

    /**
     * Define el valor de la propiedad descuento.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setDescuento(BigDecimal value) {
        this.descuento = value;
    }

    /**
     * Obtiene el valor de la propiedad moneda.
     *
     * @return
     *     possible object is
     *     {@link CMoneda }
     *
     */
    public CMoneda getMoneda() {
        return moneda;
    }

    /**
     * Define el valor de la propiedad moneda.
     *
     * @param value
     *     allowed object is
     *     {@link CMoneda }
     *
     */
    public void setMoneda(CMoneda value) {
        this.moneda = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoCambio.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getTipoCambio() {
        return tipoCambio;
    }

    /**
     * Define el valor de la propiedad tipoCambio.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setTipoCambio(BigDecimal value) {
        this.tipoCambio = value;
    }

    /**
     * Obtiene el valor de la propiedad total.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getTotal() {
        return total;
    }

    /**
     * Define el valor de la propiedad total.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setTotal(BigDecimal value) {
        this.total = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoDeComprobante.
     *
     * @return
     *     possible object is
     *     {@link CTipoDeComprobante }
     *
     */
    public CTipoDeComprobante getTipoDeComprobante() {
        return tipoDeComprobante;
    }

    /**
     * Define el valor de la propiedad tipoDeComprobante.
     *
     * @param value
     *     allowed object is
     *     {@link CTipoDeComprobante }
     *
     */
    public void setTipoDeComprobante(CTipoDeComprobante value) {
        this.tipoDeComprobante = value;
    }

    /**
     * Obtiene el valor de la propiedad metodoPago.
     *
     * @return
     *     possible object is
     *     {@link CMetodoPago }
     *
     */
    public CMetodoPago getMetodoPago() {
        return metodoPago;
    }

    /**
     * Define el valor de la propiedad metodoPago.
     *
     * @param value
     *     allowed object is
     *     {@link CMetodoPago }
     *
     */
    public void setMetodoPago(CMetodoPago value) {
        this.metodoPago = value;
    }

    /**
     * Obtiene el valor de la propiedad lugarExpedicion.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getLugarExpedicion() {
        return lugarExpedicion;
    }

    /**
     * Define el valor de la propiedad lugarExpedicion.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setLugarExpedicion(String value) {
        this.lugarExpedicion = value;
    }

    /**
     * Obtiene el valor de la propiedad confirmacion.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getConfirmacion() {
        return confirmacion;
    }

    /**
     * Define el valor de la propiedad confirmacion.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setConfirmacion(String value) {
        this.confirmacion = value;
    }


    /**
     * <p>Clase Java para anonymous complex type.
     *
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;any maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "any",
            "facturaInterfactura"
    })
    public static class Addenda {

        @XmlAnyElement(lax = true)
        protected List<Object> any;

        @XmlElement(name = "FacturaInterfactura", namespace = "https://www.interfactura.com/Schemas/Documentos", required = true)
        protected Comprobante.Addenda.FacturaInterfactura facturaInterfactura;

        public FacturaInterfactura getFacturaInterfactura() {
            return facturaInterfactura;
        }

        public void setFacturaInterfactura(FacturaInterfactura facturaInterfactura) {
            this.facturaInterfactura = facturaInterfactura;
        }

        /**
         * Gets the value of the any property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the any property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAny().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Object }
         *
         *
         */
        public List<Object> getAny() {
            if (any == null) {
                any = new ArrayList<Object>();
            }
            return this.any;
        }

        @XmlAccessorType(value = XmlAccessType.FIELD)
        @XmlType(name = "" )
        public static class FacturaInterfactura {

            @XmlAttribute(name = "Id", required = true)
            protected String Id;

            @XmlAttribute(name = "TipoDocumento", required = true)
            protected String TipoDocumento;

            @XmlElement(name = "Emisor", namespace = "https://www.interfactura.com/Schemas/Documentos", required = true)
            protected Comprobante.Addenda.FacturaInterfactura.Emisor emisor;

            @XmlElement(name = "Encabezado", namespace = "https://www.interfactura.com/Schemas/Documentos", required = true)
            protected Comprobante.Addenda.FacturaInterfactura.Encabezado encabezado;


            public String getId() {
                return Id;
            }

            public void setId(String id) {
                Id = id;
            }

            public String getTipoDocumento() {
                return TipoDocumento;
            }

            public void setTipoDocumento(String tipoDocumento) {
                TipoDocumento = tipoDocumento;
            }

            public Emisor getEmisor() {
                return emisor;
            }

            public void setEmisor(Emisor emisor) {
                this.emisor = emisor;
            }

            public Encabezado getEncabezado() {
                return encabezado;
            }

            public void setEncabezado(Encabezado encabezado) {
                this.encabezado = encabezado;
            }

            @XmlAccessorType(value = XmlAccessType.FIELD)
            @XmlType(name = "" )
            public static class Emisor {

                @XmlAttribute(name = "NumProveedor", required = true)
                protected String NumProveedor;

                public String getNumProveedor() {
                    return NumProveedor;
                }

                public void setNumProveedor(String numProveedor) {
                    NumProveedor = numProveedor;
                }
            }

            @XmlAccessorType(value = XmlAccessType.FIELD)
            @XmlType(name = "" )
            public static class Encabezado {

                @XmlAttribute(name = "NumProveedor", required = true)
                protected String NumProveedor;
                @XmlAttribute(name = "NumSucursal", required = true)
                protected String NumSucursal;
                @XmlAttribute(name = "Fecha", required = true)
                protected XMLGregorianCalendar fecha;
                @XmlAttribute(name = "FechaVencimiento", required = true)
                protected XMLGregorianCalendar fechaVencimiento;

                @XmlElement(name ="Cuerpo",  namespace = "https://www.interfactura.com/Schemas/Documentos", required = true)
                protected List<Cuerpo> cuerpos;

                public String getNumProveedor() {
                    return NumProveedor;
                }

                public void setNumProveedor(String numProveedor) {
                    NumProveedor = numProveedor;
                }

                public String getNumSucursal() { return NumSucursal; }

                public void setNumSucursal(String numSucursal) {
                    NumSucursal = numSucursal;
                }

                public XMLGregorianCalendar getFecha() {
                    return fecha;
                }

                public void setFecha(XMLGregorianCalendar fecha) {
                    this.fecha = fecha;
                }

                public XMLGregorianCalendar getFechaVencimiento() {
                    return fechaVencimiento;
                }

                public void setFechaVencimiento(XMLGregorianCalendar fechaVencimiento) {
                    this.fechaVencimiento = fechaVencimiento;
                }

                public List<Cuerpo> getCuerpos() {
                    return cuerpos;
                }

                public void setCuerpos(List<Cuerpo> cuerpos) {
                    this.cuerpos = cuerpos;
                }
            }

            @XmlAccessorType(value = XmlAccessType.FIELD)
            @XmlType(name = "" )
            public static class Cuerpo {

                @XmlAttribute(name = "Renglon", required = true)
                protected String Renglon;

                @XmlAttribute(name = "EAN13", required = true)
                protected String EAN13;

                @XmlAttribute(name = "Concepto", required = true)
                protected String Concepto;

                @XmlAttribute(name = "Cantidad", required = true)
                protected String Cantidad;

                @XmlAttribute(name = "SubTotal", required = true)
                protected String Subtotal;

                @XmlAttribute(name = "PUnitario", required = true)
                protected String PUnitario;


                public String getRenglon() {
                    return Renglon;
                }

                public void setRenglon(String renglon) {
                    Renglon = renglon;
                }

                public String getEAN13() {
                    return EAN13;
                }

                public void setEAN13(String EAN13) {
                    this.EAN13 = EAN13;
                }

                public String getConcepto() {
                    return Concepto;
                }

                public void setConcepto(String concepto) {
                    Concepto = concepto;
                }

                public String getCantidad() {
                    return Cantidad;
                }

                public void setCantidad(String cantidad) {
                    Cantidad = cantidad;
                }

                public String getSubtotal() {
                    return Subtotal;
                }

                public void setSubtotal(String subtotal) {
                    Subtotal = subtotal;
                }

                public String getPUnitario() {
                    return PUnitario;
                }

                public void setPUnitario(String PUnitario) {
                    this.PUnitario = PUnitario;
                }
            }
        }

    }



    /**
     * <p>Clase Java para anonymous complex type.
     *
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="CfdiRelacionado" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;attribute name="UUID" use="required">
     *                   &lt;simpleType>
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                       &lt;length value="36"/>
     *                       &lt;whiteSpace value="collapse"/>
     *                       &lt;pattern value="[a-f0-9A-F]{8}-[a-f0-9A-F]{4}-[a-f0-9A-F]{4}-[a-f0-9A-F]{4}-[a-f0-9A-F]{12}"/>
     *                     &lt;/restriction>
     *                   &lt;/simpleType>
     *                 &lt;/attribute>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="TipoRelacion" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_TipoRelacion" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "cfdiRelacionado"
    })
    public static class CfdiRelacionados {

        @XmlElement(name = "CfdiRelacionado", namespace = "http://www.sat.gob.mx/cfd/3", required = true)
        protected List<CfdiRelacionado> cfdiRelacionado;
        @XmlAttribute(name = "TipoRelacion", required = true)
        protected String tipoRelacion;

        /**
         * Gets the value of the cfdiRelacionado property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the cfdiRelacionado property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCfdiRelacionado().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Comprobante.CfdiRelacionados.CfdiRelacionado }
         *
         *
         */
        public List<CfdiRelacionado> getCfdiRelacionado() {
            if (cfdiRelacionado == null) {
                cfdiRelacionado = new ArrayList<CfdiRelacionado>();
            }
            return this.cfdiRelacionado;
        }

        /**
         * Obtiene el valor de la propiedad tipoRelacion.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getTipoRelacion() {
            return tipoRelacion;
        }

        /**
         * Define el valor de la propiedad tipoRelacion.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setTipoRelacion(String value) {
            this.tipoRelacion = value;
        }


        /**
         * <p>Clase Java para anonymous complex type.
         *
         * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
         *
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;attribute name="UUID" use="required">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *             &lt;length value="36"/>
         *             &lt;whiteSpace value="collapse"/>
         *             &lt;pattern value="[a-f0-9A-F]{8}-[a-f0-9A-F]{4}-[a-f0-9A-F]{4}-[a-f0-9A-F]{4}-[a-f0-9A-F]{12}"/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         *
         *
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class CfdiRelacionado {

            @XmlAttribute(name = "UUID", required = true)
            protected String uuid;

            /**
             * Obtiene el valor de la propiedad uuid.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getUUID() {
                return uuid;
            }

            /**
             * Define el valor de la propiedad uuid.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setUUID(String value) {
                this.uuid = value;
            }

        }

    }


    /**
     * <p>Clase Java para anonymous complex type.
     *
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;any maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "any"
    })
    public static class Complemento {

        @XmlAnyElement(lax = true)
        protected List<Object> any;

        /**
         * Gets the value of the any property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the any property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAny().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Object }
         *
         *
         */
        public List<Object> getAny() {
            if (any == null) {
                any = new ArrayList<Object>();
            }
            return this.any;
        }

    }


    /**
     * <p>Clase Java para anonymous complex type.
     *
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Concepto" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Impuestos" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="Traslados" minOccurs="0">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="Traslado" maxOccurs="unbounded">
     *                                         &lt;complexType>
     *                                           &lt;complexContent>
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                               &lt;attribute name="Base" use="required">
     *                                                 &lt;simpleType>
     *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
     *                                                     &lt;fractionDigits value="6"/>
     *                                                     &lt;minInclusive value="0.000001"/>
     *                                                     &lt;whiteSpace value="collapse"/>
     *                                                   &lt;/restriction>
     *                                                 &lt;/simpleType>
     *                                               &lt;/attribute>
     *                                               &lt;attribute name="Impuesto" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Impuesto" />
     *                                               &lt;attribute name="TipoFactor" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_TipoFactor" />
     *                                               &lt;attribute name="TasaOCuota">
     *                                                 &lt;simpleType>
     *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
     *                                                     &lt;fractionDigits value="6"/>
     *                                                     &lt;minInclusive value="0.000000"/>
     *                                                     &lt;whiteSpace value="collapse"/>
     *                                                   &lt;/restriction>
     *                                                 &lt;/simpleType>
     *                                               &lt;/attribute>
     *                                               &lt;attribute name="Importe" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
     *                                             &lt;/restriction>
     *                                           &lt;/complexContent>
     *                                         &lt;/complexType>
     *                                       &lt;/element>
     *                                     &lt;/sequence>
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                             &lt;element name="Retenciones" minOccurs="0">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="Retencion" maxOccurs="unbounded">
     *                                         &lt;complexType>
     *                                           &lt;complexContent>
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                               &lt;attribute name="Base" use="required">
     *                                                 &lt;simpleType>
     *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
     *                                                     &lt;fractionDigits value="6"/>
     *                                                     &lt;minInclusive value="0.000001"/>
     *                                                     &lt;whiteSpace value="collapse"/>
     *                                                   &lt;/restriction>
     *                                                 &lt;/simpleType>
     *                                               &lt;/attribute>
     *                                               &lt;attribute name="Impuesto" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Impuesto" />
     *                                               &lt;attribute name="TipoFactor" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_TipoFactor" />
     *                                               &lt;attribute name="TasaOCuota" use="required">
     *                                                 &lt;simpleType>
     *                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
     *                                                     &lt;whiteSpace value="collapse"/>
     *                                                     &lt;minInclusive value="0.000000"/>
     *                                                     &lt;fractionDigits value="6"/>
     *                                                   &lt;/restriction>
     *                                                 &lt;/simpleType>
     *                                               &lt;/attribute>
     *                                               &lt;attribute name="Importe" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
     *                                             &lt;/restriction>
     *                                           &lt;/complexContent>
     *                                         &lt;/complexType>
     *                                       &lt;/element>
     *                                     &lt;/sequence>
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="InformacionAduanera" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;attribute name="NumeroPedimento" use="required">
     *                             &lt;simpleType>
     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                 &lt;length value="21"/>
     *                                 &lt;pattern value="[0-9]{2}  [0-9]{2}  [0-9]{4}  [0-9]{7}"/>
     *                               &lt;/restriction>
     *                             &lt;/simpleType>
     *                           &lt;/attribute>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="CuentaPredial" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;attribute name="Numero" use="required">
     *                             &lt;simpleType>
     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                 &lt;minLength value="1"/>
     *                                 &lt;maxLength value="150"/>
     *                                 &lt;whiteSpace value="collapse"/>
     *                                 &lt;pattern value="[0-9]{1,150}"/>
     *                               &lt;/restriction>
     *                             &lt;/simpleType>
     *                           &lt;/attribute>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="ComplementoConcepto" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;any maxOccurs="unbounded"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="Parte" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="InformacionAduanera" maxOccurs="unbounded" minOccurs="0">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;attribute name="NumeroPedimento" use="required">
     *                                       &lt;simpleType>
     *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                           &lt;length value="21"/>
     *                                           &lt;pattern value="[0-9]{2}  [0-9]{2}  [0-9]{4}  [0-9]{7}"/>
     *                                         &lt;/restriction>
     *                                       &lt;/simpleType>
     *                                     &lt;/attribute>
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                           &lt;/sequence>
     *                           &lt;attribute name="ClaveProdServ" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_ClaveProdServ" />
     *                           &lt;attribute name="NoIdentificacion">
     *                             &lt;simpleType>
     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                 &lt;minLength value="1"/>
     *                                 &lt;maxLength value="100"/>
     *                                 &lt;whiteSpace value="collapse"/>
     *                                 &lt;pattern value="[^|]{1,100}"/>
     *                               &lt;/restriction>
     *                             &lt;/simpleType>
     *                           &lt;/attribute>
     *                           &lt;attribute name="Cantidad" use="required">
     *                             &lt;simpleType>
     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
     *                                 &lt;fractionDigits value="6"/>
     *                                 &lt;minInclusive value="0.000001"/>
     *                                 &lt;whiteSpace value="collapse"/>
     *                               &lt;/restriction>
     *                             &lt;/simpleType>
     *                           &lt;/attribute>
     *                           &lt;attribute name="Unidad">
     *                             &lt;simpleType>
     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                 &lt;minLength value="1"/>
     *                                 &lt;maxLength value="20"/>
     *                                 &lt;whiteSpace value="collapse"/>
     *                                 &lt;pattern value="[^|]{1,20}"/>
     *                               &lt;/restriction>
     *                             &lt;/simpleType>
     *                           &lt;/attribute>
     *                           &lt;attribute name="Descripcion" use="required">
     *                             &lt;simpleType>
     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                 &lt;minLength value="1"/>
     *                                 &lt;maxLength value="1000"/>
     *                                 &lt;whiteSpace value="collapse"/>
     *                                 &lt;pattern value="[^|]{1,1000}"/>
     *                               &lt;/restriction>
     *                             &lt;/simpleType>
     *                           &lt;/attribute>
     *                           &lt;attribute name="ValorUnitario" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
     *                           &lt;attribute name="Importe" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *                 &lt;attribute name="ClaveProdServ" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_ClaveProdServ" />
     *                 &lt;attribute name="NoIdentificacion">
     *                   &lt;simpleType>
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                       &lt;whiteSpace value="collapse"/>
     *                       &lt;minLength value="1"/>
     *                       &lt;maxLength value="100"/>
     *                       &lt;pattern value="[^|]{1,100}"/>
     *                     &lt;/restriction>
     *                   &lt;/simpleType>
     *                 &lt;/attribute>
     *                 &lt;attribute name="Cantidad" use="required">
     *                   &lt;simpleType>
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
     *                       &lt;fractionDigits value="6"/>
     *                       &lt;minInclusive value="0.000001"/>
     *                       &lt;whiteSpace value="collapse"/>
     *                     &lt;/restriction>
     *                   &lt;/simpleType>
     *                 &lt;/attribute>
     *                 &lt;attribute name="ClaveUnidad" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_ClaveUnidad" />
     *                 &lt;attribute name="Unidad">
     *                   &lt;simpleType>
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                       &lt;minLength value="1"/>
     *                       &lt;maxLength value="20"/>
     *                       &lt;whiteSpace value="collapse"/>
     *                       &lt;pattern value="[^|]{1,20}"/>
     *                     &lt;/restriction>
     *                   &lt;/simpleType>
     *                 &lt;/attribute>
     *                 &lt;attribute name="Descripcion" use="required">
     *                   &lt;simpleType>
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                       &lt;minLength value="1"/>
     *                       &lt;maxLength value="1000"/>
     *                       &lt;whiteSpace value="collapse"/>
     *                       &lt;pattern value="[^|]{1,1000}"/>
     *                     &lt;/restriction>
     *                   &lt;/simpleType>
     *                 &lt;/attribute>
     *                 &lt;attribute name="ValorUnitario" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
     *                 &lt;attribute name="Importe" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
     *                 &lt;attribute name="Descuento" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "concepto"
    })
    public static class Conceptos {

        @XmlElement(name = "Concepto", namespace = "http://www.sat.gob.mx/cfd/3", required = true)
        protected List<Concepto> concepto;

        /**
         * Gets the value of the concepto property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the concepto property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getConcepto().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Comprobante.Conceptos.Concepto }
         *
         *
         */
        public List<Concepto> getConcepto() {
            if (concepto == null) {
                concepto = new ArrayList<Concepto>();
            }
            return this.concepto;
        }


        /**
         * <p>Clase Java para anonymous complex type.
         *
         * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
         *
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="Impuestos" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="Traslados" minOccurs="0">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="Traslado" maxOccurs="unbounded">
         *                               &lt;complexType>
         *                                 &lt;complexContent>
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                     &lt;attribute name="Base" use="required">
         *                                       &lt;simpleType>
         *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
         *                                           &lt;fractionDigits value="6"/>
         *                                           &lt;minInclusive value="0.000001"/>
         *                                           &lt;whiteSpace value="collapse"/>
         *                                         &lt;/restriction>
         *                                       &lt;/simpleType>
         *                                     &lt;/attribute>
         *                                     &lt;attribute name="Impuesto" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Impuesto" />
         *                                     &lt;attribute name="TipoFactor" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_TipoFactor" />
         *                                     &lt;attribute name="TasaOCuota">
         *                                       &lt;simpleType>
         *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
         *                                           &lt;fractionDigits value="6"/>
         *                                           &lt;minInclusive value="0.000000"/>
         *                                           &lt;whiteSpace value="collapse"/>
         *                                         &lt;/restriction>
         *                                       &lt;/simpleType>
         *                                     &lt;/attribute>
         *                                     &lt;attribute name="Importe" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
         *                                   &lt;/restriction>
         *                                 &lt;/complexContent>
         *                               &lt;/complexType>
         *                             &lt;/element>
         *                           &lt;/sequence>
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                   &lt;element name="Retenciones" minOccurs="0">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="Retencion" maxOccurs="unbounded">
         *                               &lt;complexType>
         *                                 &lt;complexContent>
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                     &lt;attribute name="Base" use="required">
         *                                       &lt;simpleType>
         *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
         *                                           &lt;fractionDigits value="6"/>
         *                                           &lt;minInclusive value="0.000001"/>
         *                                           &lt;whiteSpace value="collapse"/>
         *                                         &lt;/restriction>
         *                                       &lt;/simpleType>
         *                                     &lt;/attribute>
         *                                     &lt;attribute name="Impuesto" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Impuesto" />
         *                                     &lt;attribute name="TipoFactor" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_TipoFactor" />
         *                                     &lt;attribute name="TasaOCuota" use="required">
         *                                       &lt;simpleType>
         *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
         *                                           &lt;whiteSpace value="collapse"/>
         *                                           &lt;minInclusive value="0.000000"/>
         *                                           &lt;fractionDigits value="6"/>
         *                                         &lt;/restriction>
         *                                       &lt;/simpleType>
         *                                     &lt;/attribute>
         *                                     &lt;attribute name="Importe" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
         *                                   &lt;/restriction>
         *                                 &lt;/complexContent>
         *                               &lt;/complexType>
         *                             &lt;/element>
         *                           &lt;/sequence>
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="InformacionAduanera" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;attribute name="NumeroPedimento" use="required">
         *                   &lt;simpleType>
         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                       &lt;length value="21"/>
         *                       &lt;pattern value="[0-9]{2}  [0-9]{2}  [0-9]{4}  [0-9]{7}"/>
         *                     &lt;/restriction>
         *                   &lt;/simpleType>
         *                 &lt;/attribute>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="CuentaPredial" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;attribute name="Numero" use="required">
         *                   &lt;simpleType>
         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                       &lt;minLength value="1"/>
         *                       &lt;maxLength value="150"/>
         *                       &lt;whiteSpace value="collapse"/>
         *                       &lt;pattern value="[0-9]{1,150}"/>
         *                     &lt;/restriction>
         *                   &lt;/simpleType>
         *                 &lt;/attribute>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="ComplementoConcepto" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;any maxOccurs="unbounded"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="Parte" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="InformacionAduanera" maxOccurs="unbounded" minOccurs="0">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;attribute name="NumeroPedimento" use="required">
         *                             &lt;simpleType>
         *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                                 &lt;length value="21"/>
         *                                 &lt;pattern value="[0-9]{2}  [0-9]{2}  [0-9]{4}  [0-9]{7}"/>
         *                               &lt;/restriction>
         *                             &lt;/simpleType>
         *                           &lt;/attribute>
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                 &lt;/sequence>
         *                 &lt;attribute name="ClaveProdServ" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_ClaveProdServ" />
         *                 &lt;attribute name="NoIdentificacion">
         *                   &lt;simpleType>
         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                       &lt;minLength value="1"/>
         *                       &lt;maxLength value="100"/>
         *                       &lt;whiteSpace value="collapse"/>
         *                       &lt;pattern value="[^|]{1,100}"/>
         *                     &lt;/restriction>
         *                   &lt;/simpleType>
         *                 &lt;/attribute>
         *                 &lt;attribute name="Cantidad" use="required">
         *                   &lt;simpleType>
         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
         *                       &lt;fractionDigits value="6"/>
         *                       &lt;minInclusive value="0.000001"/>
         *                       &lt;whiteSpace value="collapse"/>
         *                     &lt;/restriction>
         *                   &lt;/simpleType>
         *                 &lt;/attribute>
         *                 &lt;attribute name="Unidad">
         *                   &lt;simpleType>
         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                       &lt;minLength value="1"/>
         *                       &lt;maxLength value="20"/>
         *                       &lt;whiteSpace value="collapse"/>
         *                       &lt;pattern value="[^|]{1,20}"/>
         *                     &lt;/restriction>
         *                   &lt;/simpleType>
         *                 &lt;/attribute>
         *                 &lt;attribute name="Descripcion" use="required">
         *                   &lt;simpleType>
         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                       &lt;minLength value="1"/>
         *                       &lt;maxLength value="1000"/>
         *                       &lt;whiteSpace value="collapse"/>
         *                       &lt;pattern value="[^|]{1,1000}"/>
         *                     &lt;/restriction>
         *                   &lt;/simpleType>
         *                 &lt;/attribute>
         *                 &lt;attribute name="ValorUnitario" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
         *                 &lt;attribute name="Importe" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *       &lt;attribute name="ClaveProdServ" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_ClaveProdServ" />
         *       &lt;attribute name="NoIdentificacion">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *             &lt;whiteSpace value="collapse"/>
         *             &lt;minLength value="1"/>
         *             &lt;maxLength value="100"/>
         *             &lt;pattern value="[^|]{1,100}"/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *       &lt;attribute name="Cantidad" use="required">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
         *             &lt;fractionDigits value="6"/>
         *             &lt;minInclusive value="0.000001"/>
         *             &lt;whiteSpace value="collapse"/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *       &lt;attribute name="ClaveUnidad" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_ClaveUnidad" />
         *       &lt;attribute name="Unidad">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *             &lt;minLength value="1"/>
         *             &lt;maxLength value="20"/>
         *             &lt;whiteSpace value="collapse"/>
         *             &lt;pattern value="[^|]{1,20}"/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *       &lt;attribute name="Descripcion" use="required">
         *         &lt;simpleType>
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *             &lt;minLength value="1"/>
         *             &lt;maxLength value="1000"/>
         *             &lt;whiteSpace value="collapse"/>
         *             &lt;pattern value="[^|]{1,1000}"/>
         *           &lt;/restriction>
         *         &lt;/simpleType>
         *       &lt;/attribute>
         *       &lt;attribute name="ValorUnitario" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
         *       &lt;attribute name="Importe" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
         *       &lt;attribute name="Descuento" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         *
         *
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
                "impuestos",
                "informacionAduanera",
                "cuentaPredial",
                "complementoConcepto",
                "parte"
        })
        public static class Concepto {

            @XmlElement(name = "Impuestos", namespace = "http://www.sat.gob.mx/cfd/3")
            protected Comprobante.Conceptos.Concepto.Impuestos impuestos;
            @XmlElement(name = "InformacionAduanera", namespace = "http://www.sat.gob.mx/cfd/3")
            protected List<InformacionAduanera> informacionAduanera;
            @XmlElement(name = "CuentaPredial", namespace = "http://www.sat.gob.mx/cfd/3")
            protected Comprobante.Conceptos.Concepto.CuentaPredial cuentaPredial;
            @XmlElement(name = "ComplementoConcepto", namespace = "http://www.sat.gob.mx/cfd/3")
            protected Comprobante.Conceptos.Concepto.ComplementoConcepto complementoConcepto;
            @XmlElement(name = "Parte", namespace = "http://www.sat.gob.mx/cfd/3")
            protected List<Parte> parte;
            @XmlAttribute(name = "ClaveProdServ", required = true)
            protected String claveProdServ;
            @XmlAttribute(name = "NoIdentificacion")
            protected String noIdentificacion;
            @XmlAttribute(name = "Cantidad", required = true)
            protected BigDecimal cantidad;
            @XmlAttribute(name = "ClaveUnidad", required = true)
            protected String claveUnidad;
            @XmlAttribute(name = "Unidad")
            protected String unidad;
            @XmlAttribute(name = "Descripcion", required = true)
            protected String descripcion;
            @XmlAttribute(name = "ValorUnitario", required = true)
            protected BigDecimal valorUnitario;
            @XmlAttribute(name = "Importe", required = true)
            protected BigDecimal importe;
            @XmlAttribute(name = "Descuento")
            protected BigDecimal descuento;

            /**
             * Obtiene el valor de la propiedad impuestos.
             *
             * @return
             *     possible object is
             *     {@link Comprobante.Conceptos.Concepto.Impuestos }
             *
             */
            public Comprobante.Conceptos.Concepto.Impuestos getImpuestos() {
                return impuestos;
            }

            /**
             * Define el valor de la propiedad impuestos.
             *
             * @param value
             *     allowed object is
             *     {@link Comprobante.Conceptos.Concepto.Impuestos }
             *
             */
            public void setImpuestos(Comprobante.Conceptos.Concepto.Impuestos value) {
                this.impuestos = value;
            }

            /**
             * Gets the value of the informacionAduanera property.
             *
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the informacionAduanera property.
             *
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getInformacionAduanera().add(newItem);
             * </pre>
             *
             *
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Comprobante.Conceptos.Concepto.InformacionAduanera }
             *
             *
             */
            public List<InformacionAduanera> getInformacionAduanera() {
                if (informacionAduanera == null) {
                    informacionAduanera = new ArrayList<InformacionAduanera>();
                }
                return this.informacionAduanera;
            }

            /**
             * Obtiene el valor de la propiedad cuentaPredial.
             *
             * @return
             *     possible object is
             *     {@link Comprobante.Conceptos.Concepto.CuentaPredial }
             *
             */
            public Comprobante.Conceptos.Concepto.CuentaPredial getCuentaPredial() {
                return cuentaPredial;
            }

            /**
             * Define el valor de la propiedad cuentaPredial.
             *
             * @param value
             *     allowed object is
             *     {@link Comprobante.Conceptos.Concepto.CuentaPredial }
             *
             */
            public void setCuentaPredial(Comprobante.Conceptos.Concepto.CuentaPredial value) {
                this.cuentaPredial = value;
            }

            /**
             * Obtiene el valor de la propiedad complementoConcepto.
             *
             * @return
             *     possible object is
             *     {@link Comprobante.Conceptos.Concepto.ComplementoConcepto }
             *
             */
            public Comprobante.Conceptos.Concepto.ComplementoConcepto getComplementoConcepto() {
                return complementoConcepto;
            }

            /**
             * Define el valor de la propiedad complementoConcepto.
             *
             * @param value
             *     allowed object is
             *     {@link Comprobante.Conceptos.Concepto.ComplementoConcepto }
             *
             */
            public void setComplementoConcepto(Comprobante.Conceptos.Concepto.ComplementoConcepto value) {
                this.complementoConcepto = value;
            }

            /**
             * Gets the value of the parte property.
             *
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the parte property.
             *
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getParte().add(newItem);
             * </pre>
             *
             *
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Comprobante.Conceptos.Concepto.Parte }
             *
             *
             */
            public List<Parte> getParte() {
                if (parte == null) {
                    parte = new ArrayList<Parte>();
                }
                return this.parte;
            }

            /**
             * Obtiene el valor de la propiedad claveProdServ.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getClaveProdServ() {
                return claveProdServ;
            }

            /**
             * Define el valor de la propiedad claveProdServ.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setClaveProdServ(String value) {
                this.claveProdServ = value;
            }

            /**
             * Obtiene el valor de la propiedad noIdentificacion.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getNoIdentificacion() {
                return noIdentificacion;
            }

            /**
             * Define el valor de la propiedad noIdentificacion.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setNoIdentificacion(String value) {
                this.noIdentificacion = value;
            }

            /**
             * Obtiene el valor de la propiedad cantidad.
             *
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *
             */
            public BigDecimal getCantidad() {
                return cantidad;
            }

            /**
             * Define el valor de la propiedad cantidad.
             *
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *
             */
            public void setCantidad(BigDecimal value) {
                this.cantidad = value;
            }

            /**
             * Obtiene el valor de la propiedad claveUnidad.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getClaveUnidad() {
                return claveUnidad;
            }

            /**
             * Define el valor de la propiedad claveUnidad.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setClaveUnidad(String value) {
                this.claveUnidad = value;
            }

            /**
             * Obtiene el valor de la propiedad unidad.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getUnidad() {
                return unidad;
            }

            /**
             * Define el valor de la propiedad unidad.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setUnidad(String value) {
                this.unidad = value;
            }

            /**
             * Obtiene el valor de la propiedad descripcion.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getDescripcion() {
                return descripcion;
            }

            /**
             * Define el valor de la propiedad descripcion.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setDescripcion(String value) {
                this.descripcion = value;
            }

            /**
             * Obtiene el valor de la propiedad valorUnitario.
             *
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *
             */
            public BigDecimal getValorUnitario() {
                return valorUnitario;
            }

            /**
             * Define el valor de la propiedad valorUnitario.
             *
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *
             */
            public void setValorUnitario(BigDecimal value) {
                this.valorUnitario = value;
            }

            /**
             * Obtiene el valor de la propiedad importe.
             *
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *
             */
            public BigDecimal getImporte() {
                return importe;
            }

            /**
             * Define el valor de la propiedad importe.
             *
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *
             */
            public void setImporte(BigDecimal value) {
                this.importe = value;
            }

            /**
             * Obtiene el valor de la propiedad descuento.
             *
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *
             */
            public BigDecimal getDescuento() {
                return descuento;
            }

            /**
             * Define el valor de la propiedad descuento.
             *
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *
             */
            public void setDescuento(BigDecimal value) {
                this.descuento = value;
            }


            /**
             * <p>Clase Java para anonymous complex type.
             *
             * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
             *
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;any maxOccurs="unbounded"/>
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             *
             *
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                    "any"
            })
            public static class ComplementoConcepto {

                @XmlAnyElement(lax = true)
                protected List<Object> any;

                /**
                 * Gets the value of the any property.
                 *
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the any property.
                 *
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getAny().add(newItem);
                 * </pre>
                 *
                 *
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link Object }
                 *
                 *
                 */
                public List<Object> getAny() {
                    if (any == null) {
                        any = new ArrayList<Object>();
                    }
                    return this.any;
                }

            }


            /**
             * <p>Clase Java para anonymous complex type.
             *
             * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
             *
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;attribute name="Numero" use="required">
             *         &lt;simpleType>
             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *             &lt;minLength value="1"/>
             *             &lt;maxLength value="150"/>
             *             &lt;whiteSpace value="collapse"/>
             *             &lt;pattern value="[0-9]{1,150}"/>
             *           &lt;/restriction>
             *         &lt;/simpleType>
             *       &lt;/attribute>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             *
             *
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class CuentaPredial {

                @XmlAttribute(name = "Numero", required = true)
                protected String numero;

                /**
                 * Obtiene el valor de la propiedad numero.
                 *
                 * @return
                 *     possible object is
                 *     {@link String }
                 *
                 */
                public String getNumero() {
                    return numero;
                }

                /**
                 * Define el valor de la propiedad numero.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *
                 */
                public void setNumero(String value) {
                    this.numero = value;
                }

            }


            /**
             * <p>Clase Java para anonymous complex type.
             *
             * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
             *
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="Traslados" minOccurs="0">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="Traslado" maxOccurs="unbounded">
             *                     &lt;complexType>
             *                       &lt;complexContent>
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                           &lt;attribute name="Base" use="required">
             *                             &lt;simpleType>
             *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
             *                                 &lt;fractionDigits value="6"/>
             *                                 &lt;minInclusive value="0.000001"/>
             *                                 &lt;whiteSpace value="collapse"/>
             *                               &lt;/restriction>
             *                             &lt;/simpleType>
             *                           &lt;/attribute>
             *                           &lt;attribute name="Impuesto" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Impuesto" />
             *                           &lt;attribute name="TipoFactor" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_TipoFactor" />
             *                           &lt;attribute name="TasaOCuota">
             *                             &lt;simpleType>
             *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
             *                                 &lt;fractionDigits value="6"/>
             *                                 &lt;minInclusive value="0.000000"/>
             *                                 &lt;whiteSpace value="collapse"/>
             *                               &lt;/restriction>
             *                             &lt;/simpleType>
             *                           &lt;/attribute>
             *                           &lt;attribute name="Importe" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
             *                         &lt;/restriction>
             *                       &lt;/complexContent>
             *                     &lt;/complexType>
             *                   &lt;/element>
             *                 &lt;/sequence>
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *         &lt;element name="Retenciones" minOccurs="0">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="Retencion" maxOccurs="unbounded">
             *                     &lt;complexType>
             *                       &lt;complexContent>
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                           &lt;attribute name="Base" use="required">
             *                             &lt;simpleType>
             *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
             *                                 &lt;fractionDigits value="6"/>
             *                                 &lt;minInclusive value="0.000001"/>
             *                                 &lt;whiteSpace value="collapse"/>
             *                               &lt;/restriction>
             *                             &lt;/simpleType>
             *                           &lt;/attribute>
             *                           &lt;attribute name="Impuesto" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Impuesto" />
             *                           &lt;attribute name="TipoFactor" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_TipoFactor" />
             *                           &lt;attribute name="TasaOCuota" use="required">
             *                             &lt;simpleType>
             *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
             *                                 &lt;whiteSpace value="collapse"/>
             *                                 &lt;minInclusive value="0.000000"/>
             *                                 &lt;fractionDigits value="6"/>
             *                               &lt;/restriction>
             *                             &lt;/simpleType>
             *                           &lt;/attribute>
             *                           &lt;attribute name="Importe" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
             *                         &lt;/restriction>
             *                       &lt;/complexContent>
             *                     &lt;/complexType>
             *                   &lt;/element>
             *                 &lt;/sequence>
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             *
             *
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                    "traslados",
                    "retenciones"
            })
            public static class Impuestos {

                @XmlElement(name = "Traslados", namespace = "http://www.sat.gob.mx/cfd/3")
                protected Comprobante.Conceptos.Concepto.Impuestos.Traslados traslados;
                @XmlElement(name = "Retenciones", namespace = "http://www.sat.gob.mx/cfd/3")
                protected Comprobante.Conceptos.Concepto.Impuestos.Retenciones retenciones;

                /**
                 * Obtiene el valor de la propiedad traslados.
                 *
                 * @return
                 *     possible object is
                 *     {@link Comprobante.Conceptos.Concepto.Impuestos.Traslados }
                 *
                 */
                public Comprobante.Conceptos.Concepto.Impuestos.Traslados getTraslados() {
                    return traslados;
                }

                /**
                 * Define el valor de la propiedad traslados.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link Comprobante.Conceptos.Concepto.Impuestos.Traslados }
                 *
                 */
                public void setTraslados(Comprobante.Conceptos.Concepto.Impuestos.Traslados value) {
                    this.traslados = value;
                }

                /**
                 * Obtiene el valor de la propiedad retenciones.
                 *
                 * @return
                 *     possible object is
                 *     {@link Comprobante.Conceptos.Concepto.Impuestos.Retenciones }
                 *
                 */
                public Comprobante.Conceptos.Concepto.Impuestos.Retenciones getRetenciones() {
                    return retenciones;
                }

                /**
                 * Define el valor de la propiedad retenciones.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link Comprobante.Conceptos.Concepto.Impuestos.Retenciones }
                 *
                 */
                public void setRetenciones(Comprobante.Conceptos.Concepto.Impuestos.Retenciones value) {
                    this.retenciones = value;
                }


                /**
                 * <p>Clase Java para anonymous complex type.
                 *
                 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
                 *
                 * <pre>
                 * &lt;complexType>
                 *   &lt;complexContent>
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *       &lt;sequence>
                 *         &lt;element name="Retencion" maxOccurs="unbounded">
                 *           &lt;complexType>
                 *             &lt;complexContent>
                 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                 &lt;attribute name="Base" use="required">
                 *                   &lt;simpleType>
                 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
                 *                       &lt;fractionDigits value="6"/>
                 *                       &lt;minInclusive value="0.000001"/>
                 *                       &lt;whiteSpace value="collapse"/>
                 *                     &lt;/restriction>
                 *                   &lt;/simpleType>
                 *                 &lt;/attribute>
                 *                 &lt;attribute name="Impuesto" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Impuesto" />
                 *                 &lt;attribute name="TipoFactor" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_TipoFactor" />
                 *                 &lt;attribute name="TasaOCuota" use="required">
                 *                   &lt;simpleType>
                 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
                 *                       &lt;whiteSpace value="collapse"/>
                 *                       &lt;minInclusive value="0.000000"/>
                 *                       &lt;fractionDigits value="6"/>
                 *                     &lt;/restriction>
                 *                   &lt;/simpleType>
                 *                 &lt;/attribute>
                 *                 &lt;attribute name="Importe" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
                 *               &lt;/restriction>
                 *             &lt;/complexContent>
                 *           &lt;/complexType>
                 *         &lt;/element>
                 *       &lt;/sequence>
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 *
                 *
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                        "retencion"
                })
                public static class Retenciones {

                    @XmlElement(name = "Retencion", namespace = "http://www.sat.gob.mx/cfd/3", required = true)
                    protected List<Retencion> retencion;

                    /**
                     * Gets the value of the retencion property.
                     *
                     * <p>
                     * This accessor method returns a reference to the live list,
                     * not a snapshot. Therefore any modification you make to the
                     * returned list will be present inside the JAXB object.
                     * This is why there is not a <CODE>set</CODE> method for the retencion property.
                     *
                     * <p>
                     * For example, to add a new item, do as follows:
                     * <pre>
                     *    getRetencion().add(newItem);
                     * </pre>
                     *
                     *
                     * <p>
                     * Objects of the following type(s) are allowed in the list
                     * {@link Comprobante.Conceptos.Concepto.Impuestos.Retenciones.Retencion }
                     *
                     *
                     */
                    public List<Retencion> getRetencion() {
                        if (retencion == null) {
                            retencion = new ArrayList<Retencion>();
                        }
                        return this.retencion;
                    }


                    /**
                     * <p>Clase Java para anonymous complex type.
                     *
                     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
                     *
                     * <pre>
                     * &lt;complexType>
                     *   &lt;complexContent>
                     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *       &lt;attribute name="Base" use="required">
                     *         &lt;simpleType>
                     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
                     *             &lt;fractionDigits value="6"/>
                     *             &lt;minInclusive value="0.000001"/>
                     *             &lt;whiteSpace value="collapse"/>
                     *           &lt;/restriction>
                     *         &lt;/simpleType>
                     *       &lt;/attribute>
                     *       &lt;attribute name="Impuesto" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Impuesto" />
                     *       &lt;attribute name="TipoFactor" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_TipoFactor" />
                     *       &lt;attribute name="TasaOCuota" use="required">
                     *         &lt;simpleType>
                     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
                     *             &lt;whiteSpace value="collapse"/>
                     *             &lt;minInclusive value="0.000000"/>
                     *             &lt;fractionDigits value="6"/>
                     *           &lt;/restriction>
                     *         &lt;/simpleType>
                     *       &lt;/attribute>
                     *       &lt;attribute name="Importe" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
                     *     &lt;/restriction>
                     *   &lt;/complexContent>
                     * &lt;/complexType>
                     * </pre>
                     *
                     *
                     */
                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "")
                    public static class Retencion {

                        @XmlAttribute(name = "Base", required = true)
                        protected BigDecimal base;
                        @XmlAttribute(name = "Impuesto", required = true)
                        protected String impuesto;
                        @XmlAttribute(name = "TipoFactor", required = true)
                        protected CTipoFactor tipoFactor;
                        @XmlAttribute(name = "TasaOCuota", required = true)
                        protected BigDecimal tasaOCuota;
                        @XmlAttribute(name = "Importe", required = true)
                        protected BigDecimal importe;

                        /**
                         * Obtiene el valor de la propiedad base.
                         *
                         * @return
                         *     possible object is
                         *     {@link BigDecimal }
                         *
                         */
                        public BigDecimal getBase() {
                            return base;
                        }

                        /**
                         * Define el valor de la propiedad base.
                         *
                         * @param value
                         *     allowed object is
                         *     {@link BigDecimal }
                         *
                         */
                        public void setBase(BigDecimal value) {
                            this.base = value;
                        }

                        /**
                         * Obtiene el valor de la propiedad impuesto.
                         *
                         * @return
                         *     possible object is
                         *     {@link String }
                         *
                         */
                        public String getImpuesto() {
                            return impuesto;
                        }

                        /**
                         * Define el valor de la propiedad impuesto.
                         *
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *
                         */
                        public void setImpuesto(String value) {
                            this.impuesto = value;
                        }

                        /**
                         * Obtiene el valor de la propiedad tipoFactor.
                         *
                         * @return
                         *     possible object is
                         *     {@link CTipoFactor }
                         *
                         */
                        public CTipoFactor getTipoFactor() {
                            return tipoFactor;
                        }

                        /**
                         * Define el valor de la propiedad tipoFactor.
                         *
                         * @param value
                         *     allowed object is
                         *     {@link CTipoFactor }
                         *
                         */
                        public void setTipoFactor(CTipoFactor value) {
                            this.tipoFactor = value;
                        }

                        /**
                         * Obtiene el valor de la propiedad tasaOCuota.
                         *
                         * @return
                         *     possible object is
                         *     {@link BigDecimal }
                         *
                         */
                        public BigDecimal getTasaOCuota() {
                            return tasaOCuota;
                        }

                        /**
                         * Define el valor de la propiedad tasaOCuota.
                         *
                         * @param value
                         *     allowed object is
                         *     {@link BigDecimal }
                         *
                         */
                        public void setTasaOCuota(BigDecimal value) {
                            this.tasaOCuota = value;
                        }

                        /**
                         * Obtiene el valor de la propiedad importe.
                         *
                         * @return
                         *     possible object is
                         *     {@link BigDecimal }
                         *
                         */
                        public BigDecimal getImporte() {
                            return importe;
                        }

                        /**
                         * Define el valor de la propiedad importe.
                         *
                         * @param value
                         *     allowed object is
                         *     {@link BigDecimal }
                         *
                         */
                        public void setImporte(BigDecimal value) {
                            this.importe = value;
                        }

                    }

                }


                /**
                 * <p>Clase Java para anonymous complex type.
                 *
                 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
                 *
                 * <pre>
                 * &lt;complexType>
                 *   &lt;complexContent>
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *       &lt;sequence>
                 *         &lt;element name="Traslado" maxOccurs="unbounded">
                 *           &lt;complexType>
                 *             &lt;complexContent>
                 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                 &lt;attribute name="Base" use="required">
                 *                   &lt;simpleType>
                 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
                 *                       &lt;fractionDigits value="6"/>
                 *                       &lt;minInclusive value="0.000001"/>
                 *                       &lt;whiteSpace value="collapse"/>
                 *                     &lt;/restriction>
                 *                   &lt;/simpleType>
                 *                 &lt;/attribute>
                 *                 &lt;attribute name="Impuesto" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Impuesto" />
                 *                 &lt;attribute name="TipoFactor" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_TipoFactor" />
                 *                 &lt;attribute name="TasaOCuota">
                 *                   &lt;simpleType>
                 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
                 *                       &lt;fractionDigits value="6"/>
                 *                       &lt;minInclusive value="0.000000"/>
                 *                       &lt;whiteSpace value="collapse"/>
                 *                     &lt;/restriction>
                 *                   &lt;/simpleType>
                 *                 &lt;/attribute>
                 *                 &lt;attribute name="Importe" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
                 *               &lt;/restriction>
                 *             &lt;/complexContent>
                 *           &lt;/complexType>
                 *         &lt;/element>
                 *       &lt;/sequence>
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 *
                 *
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                        "traslado"
                })
                public static class Traslados {

                    @XmlElement(name = "Traslado", namespace = "http://www.sat.gob.mx/cfd/3", required = true)
                    protected List<Traslado> traslado;

                    /**
                     * Gets the value of the traslado property.
                     *
                     * <p>
                     * This accessor method returns a reference to the live list,
                     * not a snapshot. Therefore any modification you make to the
                     * returned list will be present inside the JAXB object.
                     * This is why there is not a <CODE>set</CODE> method for the traslado property.
                     *
                     * <p>
                     * For example, to add a new item, do as follows:
                     * <pre>
                     *    getTraslado().add(newItem);
                     * </pre>
                     *
                     *
                     * <p>
                     * Objects of the following type(s) are allowed in the list
                     * {@link Comprobante.Conceptos.Concepto.Impuestos.Traslados.Traslado }
                     *
                     *
                     */
                    public List<Traslado> getTraslado() {
                        if (traslado == null) {
                            traslado = new ArrayList<Traslado>();
                        }
                        return this.traslado;
                    }


                    /**
                     * <p>Clase Java para anonymous complex type.
                     *
                     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
                     *
                     * <pre>
                     * &lt;complexType>
                     *   &lt;complexContent>
                     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *       &lt;attribute name="Base" use="required">
                     *         &lt;simpleType>
                     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
                     *             &lt;fractionDigits value="6"/>
                     *             &lt;minInclusive value="0.000001"/>
                     *             &lt;whiteSpace value="collapse"/>
                     *           &lt;/restriction>
                     *         &lt;/simpleType>
                     *       &lt;/attribute>
                     *       &lt;attribute name="Impuesto" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Impuesto" />
                     *       &lt;attribute name="TipoFactor" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_TipoFactor" />
                     *       &lt;attribute name="TasaOCuota">
                     *         &lt;simpleType>
                     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
                     *             &lt;fractionDigits value="6"/>
                     *             &lt;minInclusive value="0.000000"/>
                     *             &lt;whiteSpace value="collapse"/>
                     *           &lt;/restriction>
                     *         &lt;/simpleType>
                     *       &lt;/attribute>
                     *       &lt;attribute name="Importe" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
                     *     &lt;/restriction>
                     *   &lt;/complexContent>
                     * &lt;/complexType>
                     * </pre>
                     *
                     *
                     */
                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "")
                    public static class Traslado {

                        @XmlAttribute(name = "Base", required = true)
                        protected BigDecimal base;
                        @XmlAttribute(name = "Impuesto", required = true)
                        protected String impuesto;
                        @XmlAttribute(name = "TipoFactor", required = true)
                        protected CTipoFactor tipoFactor;
                        @XmlAttribute(name = "TasaOCuota")
                        protected BigDecimal tasaOCuota;
                        @XmlAttribute(name = "Importe")
                        protected BigDecimal importe;

                        /**
                         * Obtiene el valor de la propiedad base.
                         *
                         * @return
                         *     possible object is
                         *     {@link BigDecimal }
                         *
                         */
                        public BigDecimal getBase() {
                            return base;
                        }

                        /**
                         * Define el valor de la propiedad base.
                         *
                         * @param value
                         *     allowed object is
                         *     {@link BigDecimal }
                         *
                         */
                        public void setBase(BigDecimal value) {
                            this.base = value;
                        }

                        /**
                         * Obtiene el valor de la propiedad impuesto.
                         *
                         * @return
                         *     possible object is
                         *     {@link String }
                         *
                         */
                        public String getImpuesto() {
                            return impuesto;
                        }

                        /**
                         * Define el valor de la propiedad impuesto.
                         *
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *
                         */
                        public void setImpuesto(String value) {
                            this.impuesto = value;
                        }

                        /**
                         * Obtiene el valor de la propiedad tipoFactor.
                         *
                         * @return
                         *     possible object is
                         *     {@link CTipoFactor }
                         *
                         */
                        public CTipoFactor getTipoFactor() {
                            return tipoFactor;
                        }

                        /**
                         * Define el valor de la propiedad tipoFactor.
                         *
                         * @param value
                         *     allowed object is
                         *     {@link CTipoFactor }
                         *
                         */
                        public void setTipoFactor(CTipoFactor value) {
                            this.tipoFactor = value;
                        }

                        /**
                         * Obtiene el valor de la propiedad tasaOCuota.
                         *
                         * @return
                         *     possible object is
                         *     {@link BigDecimal }
                         *
                         */
                        public BigDecimal getTasaOCuota() {
                            return tasaOCuota;
                        }

                        /**
                         * Define el valor de la propiedad tasaOCuota.
                         *
                         * @param value
                         *     allowed object is
                         *     {@link BigDecimal }
                         *
                         */
                        public void setTasaOCuota(BigDecimal value) {
                            this.tasaOCuota = value;
                        }

                        /**
                         * Obtiene el valor de la propiedad importe.
                         *
                         * @return
                         *     possible object is
                         *     {@link BigDecimal }
                         *
                         */
                        public BigDecimal getImporte() {
                            return importe;
                        }

                        /**
                         * Define el valor de la propiedad importe.
                         *
                         * @param value
                         *     allowed object is
                         *     {@link BigDecimal }
                         *
                         */
                        public void setImporte(BigDecimal value) {
                            this.importe = value;
                        }

                    }

                }

            }


            /**
             * <p>Clase Java para anonymous complex type.
             *
             * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
             *
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;attribute name="NumeroPedimento" use="required">
             *         &lt;simpleType>
             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *             &lt;length value="21"/>
             *             &lt;pattern value="[0-9]{2}  [0-9]{2}  [0-9]{4}  [0-9]{7}"/>
             *           &lt;/restriction>
             *         &lt;/simpleType>
             *       &lt;/attribute>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             *
             *
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class InformacionAduanera {

                @XmlAttribute(name = "NumeroPedimento", required = true)
                protected String numeroPedimento;

                /**
                 * Obtiene el valor de la propiedad numeroPedimento.
                 *
                 * @return
                 *     possible object is
                 *     {@link String }
                 *
                 */
                public String getNumeroPedimento() {
                    return numeroPedimento;
                }

                /**
                 * Define el valor de la propiedad numeroPedimento.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *
                 */
                public void setNumeroPedimento(String value) {
                    this.numeroPedimento = value;
                }

            }


            /**
             * <p>Clase Java para anonymous complex type.
             *
             * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
             *
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="InformacionAduanera" maxOccurs="unbounded" minOccurs="0">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;attribute name="NumeroPedimento" use="required">
             *                   &lt;simpleType>
             *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *                       &lt;length value="21"/>
             *                       &lt;pattern value="[0-9]{2}  [0-9]{2}  [0-9]{4}  [0-9]{7}"/>
             *                     &lt;/restriction>
             *                   &lt;/simpleType>
             *                 &lt;/attribute>
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *       &lt;/sequence>
             *       &lt;attribute name="ClaveProdServ" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_ClaveProdServ" />
             *       &lt;attribute name="NoIdentificacion">
             *         &lt;simpleType>
             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *             &lt;minLength value="1"/>
             *             &lt;maxLength value="100"/>
             *             &lt;whiteSpace value="collapse"/>
             *             &lt;pattern value="[^|]{1,100}"/>
             *           &lt;/restriction>
             *         &lt;/simpleType>
             *       &lt;/attribute>
             *       &lt;attribute name="Cantidad" use="required">
             *         &lt;simpleType>
             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
             *             &lt;fractionDigits value="6"/>
             *             &lt;minInclusive value="0.000001"/>
             *             &lt;whiteSpace value="collapse"/>
             *           &lt;/restriction>
             *         &lt;/simpleType>
             *       &lt;/attribute>
             *       &lt;attribute name="Unidad">
             *         &lt;simpleType>
             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *             &lt;minLength value="1"/>
             *             &lt;maxLength value="20"/>
             *             &lt;whiteSpace value="collapse"/>
             *             &lt;pattern value="[^|]{1,20}"/>
             *           &lt;/restriction>
             *         &lt;/simpleType>
             *       &lt;/attribute>
             *       &lt;attribute name="Descripcion" use="required">
             *         &lt;simpleType>
             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *             &lt;minLength value="1"/>
             *             &lt;maxLength value="1000"/>
             *             &lt;whiteSpace value="collapse"/>
             *             &lt;pattern value="[^|]{1,1000}"/>
             *           &lt;/restriction>
             *         &lt;/simpleType>
             *       &lt;/attribute>
             *       &lt;attribute name="ValorUnitario" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
             *       &lt;attribute name="Importe" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             *
             *
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                    "informacionAduanera"
            })
            public static class Parte {

                @XmlElement(name = "InformacionAduanera", namespace = "http://www.sat.gob.mx/cfd/3")
                protected List<InformacionAduanera> informacionAduanera;
                @XmlAttribute(name = "ClaveProdServ", required = true)
                protected String claveProdServ;
                @XmlAttribute(name = "NoIdentificacion")
                protected String noIdentificacion;
                @XmlAttribute(name = "Cantidad", required = true)
                protected BigDecimal cantidad;
                @XmlAttribute(name = "Unidad")
                protected String unidad;
                @XmlAttribute(name = "Descripcion", required = true)
                protected String descripcion;
                @XmlAttribute(name = "ValorUnitario")
                protected BigDecimal valorUnitario;
                @XmlAttribute(name = "Importe")
                protected BigDecimal importe;

                /**
                 * Gets the value of the informacionAduanera property.
                 *
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the informacionAduanera property.
                 *
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getInformacionAduanera().add(newItem);
                 * </pre>
                 *
                 *
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link Comprobante.Conceptos.Concepto.Parte.InformacionAduanera }
                 *
                 *
                 */
                public List<InformacionAduanera> getInformacionAduanera() {
                    if (informacionAduanera == null) {
                        informacionAduanera = new ArrayList<InformacionAduanera>();
                    }
                    return this.informacionAduanera;
                }

                /**
                 * Obtiene el valor de la propiedad claveProdServ.
                 *
                 * @return
                 *     possible object is
                 *     {@link String }
                 *
                 */
                public String getClaveProdServ() {
                    return claveProdServ;
                }

                /**
                 * Define el valor de la propiedad claveProdServ.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *
                 */
                public void setClaveProdServ(String value) {
                    this.claveProdServ = value;
                }

                /**
                 * Obtiene el valor de la propiedad noIdentificacion.
                 *
                 * @return
                 *     possible object is
                 *     {@link String }
                 *
                 */
                public String getNoIdentificacion() {
                    return noIdentificacion;
                }

                /**
                 * Define el valor de la propiedad noIdentificacion.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *
                 */
                public void setNoIdentificacion(String value) {
                    this.noIdentificacion = value;
                }

                /**
                 * Obtiene el valor de la propiedad cantidad.
                 *
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *
                 */
                public BigDecimal getCantidad() {
                    return cantidad;
                }

                /**
                 * Define el valor de la propiedad cantidad.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *
                 */
                public void setCantidad(BigDecimal value) {
                    this.cantidad = value;
                }

                /**
                 * Obtiene el valor de la propiedad unidad.
                 *
                 * @return
                 *     possible object is
                 *     {@link String }
                 *
                 */
                public String getUnidad() {
                    return unidad;
                }

                /**
                 * Define el valor de la propiedad unidad.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *
                 */
                public void setUnidad(String value) {
                    this.unidad = value;
                }

                /**
                 * Obtiene el valor de la propiedad descripcion.
                 *
                 * @return
                 *     possible object is
                 *     {@link String }
                 *
                 */
                public String getDescripcion() {
                    return descripcion;
                }

                /**
                 * Define el valor de la propiedad descripcion.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *
                 */
                public void setDescripcion(String value) {
                    this.descripcion = value;
                }

                /**
                 * Obtiene el valor de la propiedad valorUnitario.
                 *
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *
                 */
                public BigDecimal getValorUnitario() {
                    return valorUnitario;
                }

                /**
                 * Define el valor de la propiedad valorUnitario.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *
                 */
                public void setValorUnitario(BigDecimal value) {
                    this.valorUnitario = value;
                }

                /**
                 * Obtiene el valor de la propiedad importe.
                 *
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *
                 */
                public BigDecimal getImporte() {
                    return importe;
                }

                /**
                 * Define el valor de la propiedad importe.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *
                 */
                public void setImporte(BigDecimal value) {
                    this.importe = value;
                }


                /**
                 * <p>Clase Java para anonymous complex type.
                 *
                 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
                 *
                 * <pre>
                 * &lt;complexType>
                 *   &lt;complexContent>
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *       &lt;attribute name="NumeroPedimento" use="required">
                 *         &lt;simpleType>
                 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
                 *             &lt;length value="21"/>
                 *             &lt;pattern value="[0-9]{2}  [0-9]{2}  [0-9]{4}  [0-9]{7}"/>
                 *           &lt;/restriction>
                 *         &lt;/simpleType>
                 *       &lt;/attribute>
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 *
                 *
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "")
                public static class InformacionAduanera {

                    @XmlAttribute(name = "NumeroPedimento", required = true)
                    protected String numeroPedimento;

                    /**
                     * Obtiene el valor de la propiedad numeroPedimento.
                     *
                     * @return
                     *     possible object is
                     *     {@link String }
                     *
                     */
                    public String getNumeroPedimento() {
                        return numeroPedimento;
                    }

                    /**
                     * Define el valor de la propiedad numeroPedimento.
                     *
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *
                     */
                    public void setNumeroPedimento(String value) {
                        this.numeroPedimento = value;
                    }

                }

            }

        }

    }


    /**
     * <p>Clase Java para anonymous complex type.
     *
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="Rfc" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_RFC" />
     *       &lt;attribute name="Nombre">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *             &lt;minLength value="1"/>
     *             &lt;maxLength value="254"/>
     *             &lt;whiteSpace value="collapse"/>
     *             &lt;pattern value="[^|]{1,254}"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *       &lt;attribute name="RegimenFiscal" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_RegimenFiscal" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Emisor {

        @XmlAttribute(name = "Rfc", required = true)
        protected String rfc;
        @XmlAttribute(name = "Nombre")
        protected String nombre;
        @XmlAttribute(name = "RegimenFiscal", required = true)
        protected String regimenFiscal;

        /**
         * Obtiene el valor de la propiedad rfc.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getRfc() {
            return rfc;
        }

        /**
         * Define el valor de la propiedad rfc.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setRfc(String value) {
            this.rfc = value;
        }

        /**
         * Obtiene el valor de la propiedad nombre.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getNombre() {
            return nombre;
        }

        /**
         * Define el valor de la propiedad nombre.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setNombre(String value) {
            this.nombre = value;
        }

        /**
         * Obtiene el valor de la propiedad regimenFiscal.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getRegimenFiscal() {
            return regimenFiscal;
        }

        /**
         * Define el valor de la propiedad regimenFiscal.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setRegimenFiscal(String value) {
            this.regimenFiscal = value;
        }

    }


    /**
     * <p>Clase Java para anonymous complex type.
     *
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Retenciones" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Retencion" maxOccurs="unbounded">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;attribute name="Impuesto" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Impuesto" />
     *                           &lt;attribute name="Importe" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Traslados" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Traslado" maxOccurs="unbounded">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;attribute name="Impuesto" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Impuesto" />
     *                           &lt;attribute name="TipoFactor" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_TipoFactor" />
     *                           &lt;attribute name="TasaOCuota" use="required">
     *                             &lt;simpleType>
     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
     *                                 &lt;whiteSpace value="collapse"/>
     *                                 &lt;minInclusive value="0.000000"/>
     *                                 &lt;fractionDigits value="6"/>
     *                               &lt;/restriction>
     *                             &lt;/simpleType>
     *                           &lt;/attribute>
     *                           &lt;attribute name="Importe" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="TotalImpuestosRetenidos" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
     *       &lt;attribute name="TotalImpuestosTrasladados" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "retenciones",
            "traslados"
    })
    public static class Impuestos {

        @XmlElement(name = "Retenciones", namespace = "http://www.sat.gob.mx/cfd/3")
        protected Comprobante.Impuestos.Retenciones retenciones;
        @XmlElement(name = "Traslados", namespace = "http://www.sat.gob.mx/cfd/3")
        protected Comprobante.Impuestos.Traslados traslados;
        @XmlAttribute(name = "TotalImpuestosRetenidos")
        protected BigDecimal totalImpuestosRetenidos;
        @XmlAttribute(name = "TotalImpuestosTrasladados")
        protected BigDecimal totalImpuestosTrasladados;

        /**
         * Obtiene el valor de la propiedad retenciones.
         *
         * @return
         *     possible object is
         *     {@link Comprobante.Impuestos.Retenciones }
         *
         */
        public Comprobante.Impuestos.Retenciones getRetenciones() {
            return retenciones;
        }

        /**
         * Define el valor de la propiedad retenciones.
         *
         * @param value
         *     allowed object is
         *     {@link Comprobante.Impuestos.Retenciones }
         *
         */
        public void setRetenciones(Comprobante.Impuestos.Retenciones value) {
            this.retenciones = value;
        }

        /**
         * Obtiene el valor de la propiedad traslados.
         *
         * @return
         *     possible object is
         *     {@link Comprobante.Impuestos.Traslados }
         *
         */
        public Comprobante.Impuestos.Traslados getTraslados() {
            return traslados;
        }

        /**
         * Define el valor de la propiedad traslados.
         *
         * @param value
         *     allowed object is
         *     {@link Comprobante.Impuestos.Traslados }
         *
         */
        public void setTraslados(Comprobante.Impuestos.Traslados value) {
            this.traslados = value;
        }

        /**
         * Obtiene el valor de la propiedad totalImpuestosRetenidos.
         *
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *
         */
        public BigDecimal getTotalImpuestosRetenidos() {
            return totalImpuestosRetenidos;
        }

        /**
         * Define el valor de la propiedad totalImpuestosRetenidos.
         *
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *
         */
        public void setTotalImpuestosRetenidos(BigDecimal value) {
            this.totalImpuestosRetenidos = value;
        }

        /**
         * Obtiene el valor de la propiedad totalImpuestosTrasladados.
         *
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *
         */
        public BigDecimal getTotalImpuestosTrasladados() {
            return totalImpuestosTrasladados;
        }

        /**
         * Define el valor de la propiedad totalImpuestosTrasladados.
         *
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *
         */
        public void setTotalImpuestosTrasladados(BigDecimal value) {
            this.totalImpuestosTrasladados = value;
        }


        /**
         * <p>Clase Java para anonymous complex type.
         *
         * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
         *
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="Retencion" maxOccurs="unbounded">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;attribute name="Impuesto" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Impuesto" />
         *                 &lt;attribute name="Importe" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         *
         *
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
                "retencion"
        })
        public static class Retenciones {

            @XmlElement(name = "Retencion", namespace = "http://www.sat.gob.mx/cfd/3", required = true)
            protected List<Retencion> retencion;

            /**
             * Gets the value of the retencion property.
             *
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the retencion property.
             *
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getRetencion().add(newItem);
             * </pre>
             *
             *
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Comprobante.Impuestos.Retenciones.Retencion }
             *
             *
             */
            public List<Retencion> getRetencion() {
                if (retencion == null) {
                    retencion = new ArrayList<Retencion>();
                }
                return this.retencion;
            }


            /**
             * <p>Clase Java para anonymous complex type.
             *
             * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
             *
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;attribute name="Impuesto" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Impuesto" />
             *       &lt;attribute name="Importe" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             *
             *
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class Retencion {

                @XmlAttribute(name = "Impuesto", required = true)
                protected String impuesto;
                @XmlAttribute(name = "Importe", required = true)
                protected BigDecimal importe;

                /**
                 * Obtiene el valor de la propiedad impuesto.
                 *
                 * @return
                 *     possible object is
                 *     {@link String }
                 *
                 */
                public String getImpuesto() {
                    return impuesto;
                }

                /**
                 * Define el valor de la propiedad impuesto.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *
                 */
                public void setImpuesto(String value) {
                    this.impuesto = value;
                }

                /**
                 * Obtiene el valor de la propiedad importe.
                 *
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *
                 */
                public BigDecimal getImporte() {
                    return importe;
                }

                /**
                 * Define el valor de la propiedad importe.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *
                 */
                public void setImporte(BigDecimal value) {
                    this.importe = value;
                }

            }

        }


        /**
         * <p>Clase Java para anonymous complex type.
         *
         * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
         *
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="Traslado" maxOccurs="unbounded">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;attribute name="Impuesto" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Impuesto" />
         *                 &lt;attribute name="TipoFactor" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_TipoFactor" />
         *                 &lt;attribute name="TasaOCuota" use="required">
         *                   &lt;simpleType>
         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
         *                       &lt;whiteSpace value="collapse"/>
         *                       &lt;minInclusive value="0.000000"/>
         *                       &lt;fractionDigits value="6"/>
         *                     &lt;/restriction>
         *                   &lt;/simpleType>
         *                 &lt;/attribute>
         *                 &lt;attribute name="Importe" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         *
         *
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
                "traslado"
        })
        public static class Traslados {

            @XmlElement(name = "Traslado", namespace = "http://www.sat.gob.mx/cfd/3", required = true)
            protected List<Traslado> traslado;

            /**
             * Gets the value of the traslado property.
             *
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the traslado property.
             *
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getTraslado().add(newItem);
             * </pre>
             *
             *
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Comprobante.Impuestos.Traslados.Traslado }
             *
             *
             */
            public List<Traslado> getTraslado() {
                if (traslado == null) {
                    traslado = new ArrayList<Traslado>();
                }
                return this.traslado;
            }


            /**
             * <p>Clase Java para anonymous complex type.
             *
             * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
             *
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;attribute name="Impuesto" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Impuesto" />
             *       &lt;attribute name="TipoFactor" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_TipoFactor" />
             *       &lt;attribute name="TasaOCuota" use="required">
             *         &lt;simpleType>
             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
             *             &lt;whiteSpace value="collapse"/>
             *             &lt;minInclusive value="0.000000"/>
             *             &lt;fractionDigits value="6"/>
             *           &lt;/restriction>
             *         &lt;/simpleType>
             *       &lt;/attribute>
             *       &lt;attribute name="Importe" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_Importe" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             *
             *
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class Traslado {

                @XmlAttribute(name = "Impuesto", required = true)
                protected String impuesto;
                @XmlAttribute(name = "TipoFactor", required = true)
                protected CTipoFactor tipoFactor;
                @XmlAttribute(name = "TasaOCuota", required = true)
                protected BigDecimal tasaOCuota;
                @XmlAttribute(name = "Importe", required = true)
                protected BigDecimal importe;

                /**
                 * Obtiene el valor de la propiedad impuesto.
                 *
                 * @return
                 *     possible object is
                 *     {@link String }
                 *
                 */
                public String getImpuesto() {
                    return impuesto;
                }

                /**
                 * Define el valor de la propiedad impuesto.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *
                 */
                public void setImpuesto(String value) {
                    this.impuesto = value;
                }

                /**
                 * Obtiene el valor de la propiedad tipoFactor.
                 *
                 * @return
                 *     possible object is
                 *     {@link CTipoFactor }
                 *
                 */
                public CTipoFactor getTipoFactor() {
                    return tipoFactor;
                }

                /**
                 * Define el valor de la propiedad tipoFactor.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link CTipoFactor }
                 *
                 */
                public void setTipoFactor(CTipoFactor value) {
                    this.tipoFactor = value;
                }

                /**
                 * Obtiene el valor de la propiedad tasaOCuota.
                 *
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *
                 */
                public BigDecimal getTasaOCuota() {
                    return tasaOCuota;
                }

                /**
                 * Define el valor de la propiedad tasaOCuota.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *
                 */
                public void setTasaOCuota(BigDecimal value) {
                    this.tasaOCuota = value;
                }

                /**
                 * Obtiene el valor de la propiedad importe.
                 *
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *
                 */
                public BigDecimal getImporte() {
                    return importe;
                }

                /**
                 * Define el valor de la propiedad importe.
                 *
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *
                 */
                public void setImporte(BigDecimal value) {
                    this.importe = value;
                }

            }

        }

    }


    /**
     * <p>Clase Java para anonymous complex type.
     *
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="Rfc" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/tipoDatos/tdCFDI}t_RFC" />
     *       &lt;attribute name="Nombre">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *             &lt;minLength value="1"/>
     *             &lt;maxLength value="254"/>
     *             &lt;whiteSpace value="collapse"/>
     *             &lt;pattern value="[^|]{1,254}"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *       &lt;attribute name="ResidenciaFiscal" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_Pais" />
     *       &lt;attribute name="NumRegIdTrib">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *             &lt;minLength value="1"/>
     *             &lt;maxLength value="40"/>
     *             &lt;whiteSpace value="collapse"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *       &lt;attribute name="UsoCFDI" use="required" type="{http://www.sat.gob.mx/sitio_internet/cfd/catalogos}c_UsoCFDI" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Receptor {

        @XmlAttribute(name = "Rfc", required = true)
        protected String rfc;
        @XmlAttribute(name = "Nombre")
        protected String nombre;
        @XmlAttribute(name = "ResidenciaFiscal")
        protected CPais residenciaFiscal;
        @XmlAttribute(name = "NumRegIdTrib")
        protected String numRegIdTrib;
        @XmlAttribute(name = "UsoCFDI", required = true)
        protected CUsoCFDI usoCFDI;

        /**
         * Obtiene el valor de la propiedad rfc.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getRfc() {
            return rfc;
        }

        /**
         * Define el valor de la propiedad rfc.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setRfc(String value) {
            this.rfc = value;
        }

        /**
         * Obtiene el valor de la propiedad nombre.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getNombre() {
            return nombre;
        }

        /**
         * Define el valor de la propiedad nombre.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setNombre(String value) {
            this.nombre = value;
        }

        /**
         * Obtiene el valor de la propiedad residenciaFiscal.
         *
         * @return
         *     possible object is
         *     {@link CPais }
         *
         */
        public CPais getResidenciaFiscal() {
            return residenciaFiscal;
        }

        /**
         * Define el valor de la propiedad residenciaFiscal.
         *
         * @param value
         *     allowed object is
         *     {@link CPais }
         *
         */
        public void setResidenciaFiscal(CPais value) {
            this.residenciaFiscal = value;
        }

        /**
         * Obtiene el valor de la propiedad numRegIdTrib.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getNumRegIdTrib() {
            return numRegIdTrib;
        }

        /**
         * Define el valor de la propiedad numRegIdTrib.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setNumRegIdTrib(String value) {
            this.numRegIdTrib = value;
        }

        /**
         * Obtiene el valor de la propiedad usoCFDI.
         *
         * @return
         *     possible object is
         *     {@link CUsoCFDI }
         *
         */
        public CUsoCFDI getUsoCFDI() {
            return usoCFDI;
        }

        /**
         * Define el valor de la propiedad usoCFDI.
         *
         * @param value
         *     allowed object is
         *     {@link CUsoCFDI }
         *
         */
        public void setUsoCFDI(CUsoCFDI value) {
            this.usoCFDI = value;
        }

    }

}
