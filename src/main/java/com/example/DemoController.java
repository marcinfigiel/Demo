package com.example;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.multitenancy.tenantresolver.TenantResolver;


@Controller
public class DemoController
{

	private final TenantResolver tenantResolver;


	public DemoController(final TenantResolver tenantResolver)
	{
		this.tenantResolver = tenantResolver;
	}

	@Get
	public String index()
	{
		return "Hello " + tenantResolver.resolveTenantIdentifier();
	}

}
