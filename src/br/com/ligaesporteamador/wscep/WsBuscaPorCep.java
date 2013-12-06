package br.com.ligaesporteamador.wscep;

import java.net.URL;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import br.com.ligaesporteamador.model.Bairro;
import br.com.ligaesporteamador.model.Cidade;
import br.com.ligaesporteamador.model.Endereco;

/**  
 * 
 * @author Haberth
 */
public class WsBuscaPorCep {

	
	public void buscaCep(Endereco endereco) {
		if (endereco != null) {
			try {
				String cep = endereco.getCep().replace("-", "");
				URL url = new URL(
						"http://cep.republicavirtual.com.br/web_cep.php?cep="
								+ cep + "&formato=xml");
				Cidade cidade = endereco.getCidade();
				Bairro bairro = endereco.getBairro();
				Document document = getDocumento(url);

				Element root = document.getRootElement();

				for (Iterator i = root.elementIterator(); i.hasNext();) {
					Element element = (Element) i.next();

					if (element.getQualifiedName().equals("uf"))
						cidade.setUf(element.getText());

					if (element.getQualifiedName().equals("cidade"))
						cidade.setNome(element.getText());

					if (element.getQualifiedName().equals("bairro"))
						bairro.setNome(element.getText());

					if (element.getQualifiedName().equals("tipo_logradouro"))
						endereco.setTipoLogradouro(element.getText());

					if (element.getQualifiedName().equals("logradouro"))
						endereco.setNome(element.getText());

				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}

	public Document getDocumento(URL url) throws DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read(url);
		return document;
	}

}