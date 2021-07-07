package xpath.helper;

import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;
import xpath.proxies.AggregateType;
import xpath.proxies.SortMap;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.mendix.core.Core.retrieveXPathQuery;
import static com.mendix.core.Core.retrieveXPathQueryAggregate;
import static com.mendix.core.Core.retrieveXPathQueryAggregateDouble;

public class xpathHelper {

    public static List<IMendixObject> retrieveByXpath (IContext context, int Amount, int Offset, java.util.List<xpath.proxies.SortMap> Sort, IMendixObject ReturnObjectType, xpath.proxies.Xpath xpathObj) throws Exception  {


        if (xpathObj == null){
            throw new Exception("Xpath Object not provided");
        }
        if (ReturnObjectType == null){
            throw new Exception("Return object type not defined");
        }


        Map<String,String> sortMap = new HashMap<String, String>();

        for ( SortMap sort : Sort){
            Boolean sortAscending = sort.getSortAscending();

            String sortDirection;
            if (sortAscending){
                sortDirection = "ASC";
            } else {
                sortDirection = "DESC";
            }

            String sortAttribute = sort.getSortAttribute();
            sortMap.put(sortAttribute, sortDirection);
        }

        int amount;
        int offset;

        if (Amount != 0){
            amount = Amount;
            offset = Offset;
        } else {
            amount = Math.toIntExact(retrieveByXpathAggregate(context,xpathObj, AggregateType.COUNT, null, ReturnObjectType));
            offset = 0;
        }

        String xpath = getXpath(ReturnObjectType, xpathObj);
        return retrieveXPathQuery(context, xpath, amount, offset, sortMap);



    }

    public static BigDecimal retrieveByXpathAggregateDecimal (IContext context, xpath.proxies.Xpath xpathObj, xpath.proxies.AggregateType AggregateType, java.lang.String attributeName, IMendixObject ReturnObjectType) throws Exception  {

        String xpathQuery = getXpathAggregateQuery(ReturnObjectType, xpathObj, AggregateType,attributeName);

        if (xpathQuery == null){
            throw new Exception("Aggregate type not defined");
        }

        Double aggregateResult = retrieveXPathQueryAggregateDouble(context, xpathQuery);
        if (aggregateResult != null){
            BigDecimal bigdecimal = new BigDecimal(aggregateResult);

            return bigdecimal;
        }else{
            return null;
        }

    }

    public static Long retrieveByXpathAggregate (IContext context, xpath.proxies.Xpath xpathObj, xpath.proxies.AggregateType AggregateType, java.lang.String attributeName, IMendixObject ReturnObjectType) throws Exception  {

        String xpathQuery = getXpathAggregateQuery(ReturnObjectType, xpathObj, AggregateType,attributeName);

        if (xpathQuery == null){
            throw new Exception("Aggregate type not defined");
        }

        Long aggregateResult = retrieveXPathQueryAggregate(context, xpathQuery);
        if (aggregateResult != null){

            return aggregateResult;
        }else{
            return null;
        }

    }


    public static String getXpath (IMendixObject ReturnObjectType, xpath.proxies.Xpath xpathObj) {

        String xpathStart = "//" +  ReturnObjectType.getMetaObject().getName();
        String xpath;

        if (xpathObj.getQuery() == null){

          xpath = xpathStart;

        } else {

           xpath = xpathStart + xpathObj.getQuery();
        }

        return xpath;
    }

    public static String getXpathAggregateQuery (IMendixObject ReturnObjectType, xpath.proxies.Xpath xpathObj, xpath.proxies.AggregateType AggregateType, java.lang.String attributeName) {

        String xpathQuery;
        String xpathConstraint = getXpath(ReturnObjectType, xpathObj);

        if (AggregateType == xpath.proxies.AggregateType.COUNT) {
            xpathQuery = "COUNT(" + xpathConstraint + ")";
        } else if (AggregateType == xpath.proxies.AggregateType.AVG){
            xpathQuery = "AVG(" + xpathConstraint + "/" + attributeName + ")";
        } else if (AggregateType == xpath.proxies.AggregateType.MAX){
            xpathQuery = "MAX(" + xpathConstraint + "/" + attributeName + ")";
        } else if (AggregateType == xpath.proxies.AggregateType.MIN){
            xpathQuery = "MIN(" + xpathConstraint + "/" + attributeName + ")";
        } else if (AggregateType == xpath.proxies.AggregateType.SUM){
            xpathQuery = "SUM(" + xpathConstraint + "/" + attributeName + ")";
        } else {
            xpathQuery = null;
        }

        return xpathQuery;
    }


}
