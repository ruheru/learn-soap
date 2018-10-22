package com.learn.webservice.aplikasisiup.endpoint;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import generated.DaftarKelurahan;
import generated.DaftarKelurahanRequest;
import generated.DaftarKelurahanResponse;
import generated.Kelurahan;

@Endpoint
public class KelurahanEndpoint {

	public List<Kelurahan> cari(String nama){
		List<Kelurahan> hasil = new ArrayList<>();
		Kelurahan k1 = new Kelurahan();
		k1.setId(new BigInteger("1"));
		k1.setKode("K-001");
		k1.setNama(nama);
		k1.setKodepos(new BigInteger("15413"));
		hasil.add(k1);
		
		Kelurahan k2 = new Kelurahan();
		k2.setId(new BigInteger("2"));
		k2.setKode("K-002");
		k2.setNama(nama);
		k2.setKodepos(new BigInteger("15414"));
		hasil.add(k2);
		
		return hasil; 
	}
	
	//payload local part agar yang kita cari nanti element daftarKelurahanRequest dari parameter xml nya
	@PayloadRoot(localPart = "daftarKelurahanRequest", namespace="http://aplikasisiup.com/webservices/siup")
	@ResponsePayload
	public DaftarKelurahanResponse cariKelurahan(@RequestPayload DaftarKelurahanRequest request) {
		String cariNama = request.getPencarian().getNama();
		//harusnya make db tapi untuk sementara di sysout aja dulu
		System.out.println("Mencari kelurahan dengan nama : "+cariNama);
		
		DaftarKelurahanResponse response = new DaftarKelurahanResponse();
		DaftarKelurahan soapBody = new DaftarKelurahan();
		soapBody.setKelurahan(cari(cariNama));
		response.setDaftarKelurahan(soapBody);
		
		return response;
	}
	
}
