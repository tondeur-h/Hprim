package org.ht.hprim.parser;

import org.ht.hprim.parser.HPRIMSTokenSource;
import org.ht.hprim.parser.HPRIMSInputStreamReader;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.junit.Test;

import org.ht.hprim.parser.antlr.HPRIMSParser;

public class HPRIMSTokenSourceTest {

	@Test
	public void testGetCharTokenClass() throws IOException {
		String tt1 = ".";
		HPRIMSInputStreamReader isr = new HPRIMSInputStreamReader(new ByteArrayInputStream(tt1.getBytes()));
		HPRIMSTokenSource tok = new HPRIMSTokenSource(isr);
		assertEquals(HPRIMSParser.POINT, tok.getCharTokenClass('.'));
	}

}
