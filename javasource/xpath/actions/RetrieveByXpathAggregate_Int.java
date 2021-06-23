// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package xpath.actions;

import com.mendix.core.Core;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;
import com.mendix.systemwideinterfaces.core.IMendixObject;
import xpath.helper.xpathHelper;
import xpath.proxies.AggregateType;
import xpath.proxies.SortMap;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import static com.mendix.core.Core.*;

public class RetrieveByXpathAggregate_Int extends CustomJavaAction<java.lang.Long>
{
	private IMendixObject ReturnObjectType;
	private IMendixObject __Xpath;
	private xpath.proxies.Xpath Xpath;
	private xpath.proxies.AggregateType AggregateType;
	private java.lang.String attributeName;

	public RetrieveByXpathAggregate_Int(IContext context, IMendixObject ReturnObjectType, IMendixObject Xpath, java.lang.String AggregateType, java.lang.String attributeName)
	{
		super(context);
		this.ReturnObjectType = ReturnObjectType;
		this.__Xpath = Xpath;
		this.AggregateType = AggregateType == null ? null : xpath.proxies.AggregateType.valueOf(AggregateType);
		this.attributeName = attributeName;
	}

	@java.lang.Override
	public java.lang.Long executeAction() throws Exception
	{
		this.Xpath = __Xpath == null ? null : xpath.proxies.Xpath.initialize(getContext(), __Xpath);

		// BEGIN USER CODE
		Long result = xpathHelper.retrieveByXpathAggregate(getContext(), Xpath, AggregateType, attributeName, ReturnObjectType);
		return result == null ? null : result;
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@java.lang.Override
	public java.lang.String toString()
	{
		return "RetrieveByXpathAggregate_Int";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}